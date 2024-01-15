package com.aui.Laboratorium5.series.controller.impl;

import com.aui.Laboratorium5.series.DTO.GetSeriesResponse;
import com.aui.Laboratorium5.series.DTO.GetSeriessResponse;
import com.aui.Laboratorium5.series.DTO.PatchSeriesRequest;
import com.aui.Laboratorium5.series.DTO.PutSeriesRequest;
import com.aui.Laboratorium5.series.controller.api.SeriesController;
import com.aui.Laboratorium5.series.entity.Series;
import com.aui.Laboratorium5.series.function.*;
import com.aui.Laboratorium5.series.service.api.SeriesService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class SeriesDefaultController implements SeriesController {

    private final SeriesService service;
    private final SeriesToResponseFunc seriesToResponse;
    private final SeriessToResponseFunc seriessToResponse;
    private final RequestToSeriesFunc requestToSeries;
    private final UpdateSeriesWithRequestFunc updateSeriesWithRequest;

    @Autowired
    public SeriesDefaultController(
            SeriesService service,
            SeriesToResponseFunc seriesToResponse,
            SeriessToResponseFunc seriessToResponse,
            RequestToSeriesFunc requestToSeries,
            UpdateSeriesWithRequestFunc updateSeriesWithRequest
    ) {
        this.service = service;
        this.seriesToResponse = seriesToResponse;
        this.seriessToResponse = seriessToResponse;
        this.requestToSeries = requestToSeries;
        this.updateSeriesWithRequest = updateSeriesWithRequest;
    }
   
    @Override
    public GetSeriessResponse getSeries() {return seriessToResponse.apply(service.findAll());}

    @Override
    public GetSeriesResponse getSeries(UUID id) {
        return seriesToResponse.apply(service.find(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public void putSeries(UUID id, PutSeriesRequest request) {
        service.create(requestToSeries.apply(id,request));
    }

    @Override
    public void updateSeries(UUID id, PatchSeriesRequest request) {
        service.update(updateSeriesWithRequest.apply(service.find(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)),request));
    }

    @Override
    public void deleteSeries(UUID id) {
        Optional<Series> series = service.find(id);
        if (series.isPresent())
        {
            service.delete(id);
        }else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

