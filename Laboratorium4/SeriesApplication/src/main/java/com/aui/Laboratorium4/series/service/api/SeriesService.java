package com.aui.Laboratorium4.series.service.api;

import com.aui.Laboratorium4.series.entity.Series;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeriesService {
    void update(Series series);
    void create(Series series);
    void delete(UUID id);
    void delete(String seriesName);
    Optional<Series> find(UUID id);
    Optional<Series> findByName(String seriesName);

    List<Series> findAll();
}
