package com.aui.Laboratorium4.series.function;

import com.aui.Laboratorium4.series.DTO.PutSeriesRequest;
import com.aui.Laboratorium4.series.entity.Series;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToSeriesFunc implements BiFunction<UUID, PutSeriesRequest, Series> {
    @Override
    public Series apply(UUID id, PutSeriesRequest request)
    {
        return Series.builder()
                .id(id)
                .seriesName(request.getSeriesName())
                .numberOfSeasons(request.getNumberOfSeasons())
                .build();
    }
}