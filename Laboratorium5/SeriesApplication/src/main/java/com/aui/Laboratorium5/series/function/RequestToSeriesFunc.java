package com.aui.Laboratorium5.series.function;

import com.aui.Laboratorium5.series.DTO.PutSeriesRequest;
import com.aui.Laboratorium5.series.entity.Series;
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