package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.PatchSeriesRequest;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import java.util.function.BiFunction;

@Component
public class UpdateSeriesWithRequestFunc implements BiFunction<TVSeries, PatchSeriesRequest, TVSeries>{
    @Override
    public TVSeries apply(TVSeries entity, PatchSeriesRequest request)
        {
            return TVSeries.builder()
                    .id(entity.getId())
                    .seriesName(request.getSeriesName())
                    .numberOfSeasons(request.getNumberOfSeasons())
                    .characters(entity.getCharacters())
                    .build();
        }
}
