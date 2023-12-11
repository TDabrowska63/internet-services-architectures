package com.aui.Laboratorium4.series.service.impl;

import com.aui.Laboratorium4.series.entity.Series;
import com.aui.Laboratorium4.series.event.repository.api.SeriesEventRepository;
import com.aui.Laboratorium4.series.repository.api.SeriesRepository;
import com.aui.Laboratorium4.series.service.api.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeriesDefaultService implements SeriesService {
    private final SeriesRepository repository;
    private final SeriesEventRepository eventRepository;

    @Autowired
    public SeriesDefaultService(SeriesRepository repository, SeriesEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void update(Series series) {
        repository.save(series);
    }

    @Override
    public void create(Series series) {
        repository.save(series);
        eventRepository.save(series);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }

    @Override
    public void delete(String seriesName) {
        repository.findBySeriesName(seriesName).ifPresent(repository::delete);
    }

    @Override
    public Optional<Series> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Series> findByName(String seriesName) {
        return repository.findBySeriesName(seriesName);
    }

    @Override
    public List<Series> findAll() {
        return repository.findAll();
    }

}