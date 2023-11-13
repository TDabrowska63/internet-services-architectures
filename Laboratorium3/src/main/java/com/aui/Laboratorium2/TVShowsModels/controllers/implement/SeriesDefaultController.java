package com.aui.Laboratorium2.TVShowsModels.controllers.implement;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.aui.Laboratorium2.TVShowsModels.DTO.*;
import com.aui.Laboratorium2.TVShowsModels.controllers.api.SeriesController;
import com.aui.Laboratorium2.TVShowsModels.functions.*;
import com.aui.Laboratorium2.TVShowsModels.services.TVSeriesService;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;

import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class SeriesDefaultController implements SeriesController{
    private final TVSeriesService service;
    private final TVSeriesToResponseFunction seriesToResponse;
    private final TVSeriessToResponseFunction seriessToResponse;
    private final RequestToTVSeriesFunction requestToSeries;
    private final UpdateTVSeriesWithRequestFunction updateSeriesWithRequest;

    @Autowired
    public SeriesDefaultController(
            TVSeriesService service,
            TVSeriesToResponseFunction seriesToResponse,
            TVSeriessToResponseFunction seriessToResponse,
            RequestToTVSeriesFunction requestToSeries,
            UpdateTVSeriesWithRequestFunction updateSeriesWithRequest
    ) {
        this.service = service;
        this.seriesToResponse = seriesToResponse;
        this.seriessToResponse = seriessToResponse;
        this.requestToSeries = requestToSeries;
        this.updateSeriesWithRequest = updateSeriesWithRequest;
    }

    @Override
    public GetMultipleSeriesResponse getMultipleSeries() {
        return seriessToResponse.apply(service.findAll());
    }

    @Override
    public GetSeriesResponse getSeries(UUID id) {
        return seriesToResponse.apply(service.find(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public void putSeries(UUID id, PutSeriesRequest request) {
        TVSeries series = requestToSeries.apply(request);
        series.setId(id);
        service.save(series);
    }

    @Override
    public void updateSeries(UUID id, PatchSeriesRequest request) {
        TVSeries series = service.find(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        updateSeriesWithRequest
}
