package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.PutSeriesRequest;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToSeriesFunc implements BiFunction<UUID, PutSeriesRequest, TVSeries>{
    @Override
    public TVSeries apply(UUID id, PutSeriesRequest request)
        {
            return TVSeries.builder()
                    .id(id)
                    .seriesName(request.getSeriesName())
                    .numberOfSeasons(request.getNumberOfSeasons())
                    .build();
        }
}
