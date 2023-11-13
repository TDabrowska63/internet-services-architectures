package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.GetSeriesResponse;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import java.util.function.Function;

@Component
public class SeriesToResponseFunc implements Function<TVSeries, GetSeriesResponse>{
    public GetSeriesResponse apply(TVSeries entity)
        {
            return GetSeriesResponse.builder()
                    .id(entity.getId())
                    .seriesName(entity.getSeriesName())
                    .numberOfSeasons(entity.getNumberOfSeasons())
                    .build();
        }
}
