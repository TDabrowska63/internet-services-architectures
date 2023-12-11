package com.aui.Laboratorium4.series.event.repository.api;

import com.aui.Laboratorium4.series.entity.Series;

import java.util.UUID;

public interface SeriesEventRepository {
    void delete(UUID id);
    void save(Series series);
}
