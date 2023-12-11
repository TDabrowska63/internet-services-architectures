package com.aui.Laboratorium4.series.controller.impl;

import com.aui.Laboratorium4.series.DTO.PostSeriesRequest;
import com.aui.Laboratorium4.series.functions.RequestToSeriesFunction;
import com.aui.Laboratorium4.series.service.api.SeriesService;
import com.aui.Laboratorium4.series.controller.api.TVSeriesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TVSeriesDefaultController implements TVSeriesController {
    private final SeriesService service;
    private final RequestToSeriesFunction requestToFleet;
    @Autowired
    public TVSeriesDefaultController(SeriesService service, RequestToSeriesFunction request) {
        this.service=service;
        this.requestToFleet = request;
    }
    @Override
    public void putFleet(PostSeriesRequest request) {
        service.create(requestToFleet.apply(request));
    }

    @Override
    public void deleteFleet(UUID id) {
        service.delete(id);
    }
}