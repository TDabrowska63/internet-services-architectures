package com.aui.Laboratorium5.series.event.repository.api;

import com.aui.Laboratorium5.series.entity.Series;

import java.util.UUID;

public interface SeriesEventRepository {
    void delete(UUID id);
    void save(Series series);
}
