package com.aui.Laboratorium2.TVShowsModels.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TVSeriesRepository extends JpaRepository<TVSeries, UUID> {
        Optional<TVSeries> findBySeriesName(String seriesName);
}
