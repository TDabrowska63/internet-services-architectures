package com.aui.Laboratorium5.series.repository.api;

import com.aui.Laboratorium5.series.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeriesRepository extends JpaRepository<Series, UUID> {
}
