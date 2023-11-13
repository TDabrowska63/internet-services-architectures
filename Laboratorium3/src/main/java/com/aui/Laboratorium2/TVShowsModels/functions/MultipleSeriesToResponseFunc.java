package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.GetMultipleSeriesResponse;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import java.util.List;
import java.util.function.Function;

@Component
public class MultipleSeriesToResponseFunc implements Function<List<TVSeries>, GetMultipleSeriesResponse>{
    @Override
    public GetMultipleSeriesResponse apply(List<TVSeries> entities)
        {
            return GetMultipleSeriesResponse.builder()
                    .series(entities.stream()
                            .map(series -> GetMultipleSeriesResponse.TVSeries.builder()
                                    .id(series.getId())
                                    .seriesName(series.getSeriesName())
                                    .build())
                            .toList())
                    .build();
        }
}
