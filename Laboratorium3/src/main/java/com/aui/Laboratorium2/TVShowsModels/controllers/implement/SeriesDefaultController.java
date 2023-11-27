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
public class SeriesDefaultController implements SeriesController {
    private final TVSeriesService service;
    private final SeriesToResponseFunc seriesToResponse;
    private final SeriessToResponseFunc seriessToResponse;
    private final RequestToSeriesFunc requestToSeries;
    private final UpdateSeriesWithRequestFunc updateSeriesWithRequest;

    @Autowired
    public SeriesDefaultController(
            TVSeriesService service,
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
    public GetSeriessResponse getSeriess() {
        return seriessToResponse.apply(service.findAll());
    }

    @Override
    public GetSeriesResponse getSeries(UUID id) {
        return seriesToResponse.apply(service.find(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public void putSeries(UUID id, PutSeriesRequest request) {
        service.create(requestToSeries.apply(id, request));
    }

    @Override
    public void updateSeries(UUID id, PatchSeriesRequest request) {
        service.update(updateSeriesWithRequest.apply(service.find(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
    }

    @Override
    public void deleteSeries(UUID id) {
        Optional<TVSeries> fleet = service.find(id);
        if (fleet.isPresent()) {
            service.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
