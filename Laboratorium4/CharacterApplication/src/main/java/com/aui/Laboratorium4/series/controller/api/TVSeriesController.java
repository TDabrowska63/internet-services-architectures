package com.aui.Laboratorium4.series.controller.api;

import com.aui.Laboratorium4.series.DTO.PostSeriesRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface TVSeriesController {
    @PostMapping("api/fleets/")
    @ResponseStatus(HttpStatus.CREATED)
    void putFleet(
            @RequestBody
            PostSeriesRequest request
    );

    @DeleteMapping("api/fleets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFleet(
            @PathVariable("id")
            UUID id
    );
}