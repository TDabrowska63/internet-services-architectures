package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.PutCharacterRequest;
import com.aui.Laboratorium2.TVShowsModels.Character;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToCharacterFunc implements BiFunction<UUID, PutCharacterRequest, Character>{
    @Override
    public Character apply(UUID id, PutCharacterRequest request)
        {
            return Character.builder()
                    .id(id)
                    .name(request.getName())
                    .series(TVSeries.builder().id(request.getSeriesId()).build())
                    .build();
        }
}
