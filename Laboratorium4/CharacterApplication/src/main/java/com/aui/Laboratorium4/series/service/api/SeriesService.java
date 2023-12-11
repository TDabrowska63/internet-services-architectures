package com.aui.Laboratorium4.series.service.api;

import com.aui.Laboratorium4.series.entity.Series;
import java.util.Optional;
import java.util.UUID;

public interface SeriesService {

    Optional<Series> find(UUID id);
    void create(Series series);
    void delete(UUID id);
}
