package com.aui.Laboratorium5.series.controller.api;

import com.aui.Laboratorium5.series.DTO.GetSeriesResponse;
import com.aui.Laboratorium5.series.DTO.GetSeriessResponse;
import com.aui.Laboratorium5.series.DTO.PatchSeriesRequest;
import com.aui.Laboratorium5.series.DTO.PutSeriesRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SeriesController {
    @GetMapping("api/series")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSeriessResponse getSeries();

    @GetMapping("api/series/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSeriesResponse getSeries(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("api/series/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSeries(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutSeriesRequest request
    );

    @PatchMapping("api/series/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
