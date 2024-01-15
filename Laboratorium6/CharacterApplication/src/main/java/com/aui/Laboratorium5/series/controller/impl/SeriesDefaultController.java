package com.aui.Laboratorium5.series.controller.impl;

import com.aui.Laboratorium5.series.DTO.PostSeriesRequest;
import com.aui.Laboratorium5.series.functions.RequestToSeriesFunction;
import com.aui.Laboratorium5.series.service.api.SeriesService;
import com.aui.Laboratorium5.series.controller.api.SeriesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SeriesDefaultController implements SeriesController {
    private final SeriesService service;
    private final RequestToSeriesFunction requestToSeries;
    @Autowired
    public SeriesDefaultController(SeriesService service, RequestToSeriesFunction request) {
        this.service=service;
        this.requestToSeries = request;
    }
    @Override
    public void putSeries(PostSeriesRequest request) {
        service.create(requestToSeries.apply(request));
    }

    @Override
    public void deleteSeries(UUID id) {
        service.delete(id);
    }
}