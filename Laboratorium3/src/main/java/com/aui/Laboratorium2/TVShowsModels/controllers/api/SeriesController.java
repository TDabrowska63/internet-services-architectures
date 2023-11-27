package com.aui.Laboratorium2.TVShowsModels.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.aui.Laboratorium2.TVShowsModels.DTO.*;

import java.util.UUID;

public interface SeriesController {
    @GetMapping("api/series")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSeriessResponse getSeriess();

    @GetMapping("api/series/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSeriesResponse getSeries(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("api/series/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void putSeries(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutSeriesRequest request
    );

    @PatchMapping("api/series/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void updateSeries(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchSeriesRequest request
    );

    @DeleteMapping("api/series/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteSeries(
            @PathVariable("id")
            UUID id
    );


}
