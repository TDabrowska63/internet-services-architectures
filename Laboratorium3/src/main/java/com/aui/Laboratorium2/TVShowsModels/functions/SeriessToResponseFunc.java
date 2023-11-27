package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.GetSeriessResponse;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import java.util.List;
import java.util.function.Function;

@Component
public class SeriessToResponseFunc implements Function<List<TVSeries>, GetSeriessResponse>{
    @Override
    public GetSeriessResponse apply(List<TVSeries> entities)
        {
            return GetSeriessResponse.builder()
                    .series(entities.stream()
                            .map(series -> GetSeriessResponse.TVSeries.builder()
                                    .id(series.getId())
                                    .seriesName(series.getSeriesName())
                                    .build())
                            .toList())
                    .build();
        }
}
