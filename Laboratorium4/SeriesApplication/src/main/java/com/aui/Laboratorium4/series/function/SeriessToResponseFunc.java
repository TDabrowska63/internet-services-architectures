package com.aui.Laboratorium4.series.function;

import com.aui.Laboratorium4.series.DTO.GetSeriessResponse;
import com.aui.Laboratorium4.series.entity.Series;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SeriessToResponseFunc implements Function<List<Series>, GetSeriessResponse> {
    @Override
    public GetSeriessResponse apply(List<Series> entities)
    {
        return GetSeriessResponse.builder()
                .seriess(entities.stream()
                        .map(series -> GetSeriessResponse.Series.builder()
                                .id(series.getId())
                                .seriesName(series.getSeriesName())
                                .build())
                        .toList())
                .build();
    }
}