package com.aui.Laboratorium2.TVShowsModels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import com.aui.Laboratorium2.TVShowsModels.repositories.TVSeriesRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TVSeriesDefaultService implements TVSeriesService{
    private final TVSeriesRepository repository;

    @Autowired
    public TVSeriesDefaultService(TVSeriesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void update(TVSeries series) {
        repository.save(series);
    }

    @Override
    public void create(TVSeries series) {
        repository.save(series);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void delete(String seriesName) {
        repository.findBySeriesName(seriesName).ifPresent(repository::delete);
    }

    @Override
    public Optional<TVSeries> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<TVSeries> findByName(String seriesName) {
        return repository.findBySeriesName(seriesName);
    }

    @Override
    public List<TVSeries> findAll() {
        return repository.findAll();
    }
}
