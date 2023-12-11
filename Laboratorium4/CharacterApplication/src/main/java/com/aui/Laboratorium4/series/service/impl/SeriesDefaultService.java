package com.aui.Laboratorium4.series.service.impl;

import com.aui.Laboratorium4.series.entity.Series;
import com.aui.Laboratorium4.series.repository.api.TVSeriesRepository;
import com.aui.Laboratorium4.series.service.api.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SeriesDefaultService implements SeriesService {
    private final TVSeriesRepository repository;
    @Autowired
    public SeriesDefaultService(TVSeriesRepository repository){this.repository = repository;}
    @Override
    public Optional<Series> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(Series series) {
        repository.save(series);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
