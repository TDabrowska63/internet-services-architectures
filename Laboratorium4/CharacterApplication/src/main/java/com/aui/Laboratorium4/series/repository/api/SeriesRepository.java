package com.aui.Laboratorium4.series.repository.api;

import com.aui.Laboratorium4.series.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeriesRepository extends JpaRepository<Series, UUID> {
}
