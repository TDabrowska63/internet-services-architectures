package com.aui.Laboratorium5.series.event.repository.rest;

import com.aui.Laboratorium5.series.entity.Series;
import com.aui.Laboratorium5.series.event.repository.api.SeriesEventRepository;
import com.aui.Laboratorium5.series.function.SeriesToRequestFunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class SeriesEventRestRepository implements SeriesEventRepository {
    private final RestTemplate restTemplate;
    private final SeriesToRequestFunc seriesToRequest;
    @Autowired
    public SeriesEventRestRepository(RestTemplate template, SeriesToRequestFunc function){
        this.restTemplate = template;
        this.seriesToRequest = function;
    }
    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/series/{id}",id);
    }

    @Override
    public void save(Series series) {
        restTemplate.postForLocation("/api/series/", seriesToRequest.apply(series));
    }
}
