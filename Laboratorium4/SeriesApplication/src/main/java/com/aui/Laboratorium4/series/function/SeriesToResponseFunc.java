package com.aui.Laboratorium4.series.function;

import com.aui.Laboratorium4.series.DTO.GetSeriesResponse;
import com.aui.Laboratorium4.series.entity.Series;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SeriesToResponseFunc implements Function<Series, GetSeriesResponse> {
    @Override
    public GetSeriesResponse apply(Series entity)
    {
        return GetSeriesResponse.builder()
                .id(entity.getId())
                .seriesName(entity.getSeriesName())
                .numberOfSeasons(entity.getNumberOfSeasons())
                .build();
    }
}