package com.aui.Laboratorium4.series.function;

import com.aui.Laboratorium4.series.DTO.PatchSeriesRequest;
import com.aui.Laboratorium4.series.entity.Series;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateSeriesWithRequestFunc implements BiFunction<Series, PatchSeriesRequest, Series> {
    @Override
    public Series apply(Series entity, PatchSeriesRequest request)
    {
        return Series.builder()
                .id(entity.getId())
                .seriesName(request.getSeriesName())
                .numberOfSeasons(request.getNumberOfSeasons())
                .build();
    }
}
