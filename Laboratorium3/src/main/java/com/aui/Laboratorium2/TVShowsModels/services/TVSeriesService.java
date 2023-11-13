package com.aui.Laboratorium2.TVShowsModels.services;

import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TVSeriesService {
    // ************ EX 3 ************
    void update(TVSeries series);
    void create(TVSeries series);
    void delete(UUID id);
    void delete(String seriesName);
    Optional<TVSeries> find(UUID id);
    Optional<TVSeries> findByName(String seriesName);

    List<TVSeries> findAll();
}
