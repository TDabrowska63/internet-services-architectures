package com.aui.Laboratorium5.series.service.impl;

import com.aui.Laboratorium5.series.entity.Series;
import com.aui.Laboratorium5.series.repository.api.SeriesRepository;
import com.aui.Laboratorium5.series.service.api.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SeriesDefaultService implements SeriesService {
    private final SeriesRepository repository;
    @Autowired
    public SeriesDefaultService(SeriesRepository repository){this.repository = repository;}
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
