package com.aui.Laboratorium4.series.repository.api;


import com.aui.Laboratorium4.series.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SeriesRepository extends JpaRepository<Series, UUID> {
    Optional<Series> findBySeriesName(String seriesName);
}
