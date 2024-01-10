package com.aui.Laboratorium4.series.controller.api;

import com.aui.Laboratorium4.series.DTO.PostSeriesRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SeriesController {
    @PostMapping("api/series/")
    @ResponseStatus(HttpStatus.CREATED)
    void putSeries(
            @RequestBody
            PostSeriesRequest request
    );

    @DeleteMapping("api/series/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSeries(
            @PathVariable("id")
            UUID id
    );
}