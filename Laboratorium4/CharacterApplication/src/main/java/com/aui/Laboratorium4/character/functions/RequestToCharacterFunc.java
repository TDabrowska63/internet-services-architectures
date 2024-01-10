package com.aui.Laboratorium4.character.functions;

import com.aui.Laboratorium4.character.DTO.PutCharacterRequest;
import com.aui.Laboratorium4.character.entity.Character;
import org.springframework.stereotype.Component;
import com.aui.Laboratorium4.series.entity.Series;

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
                    .series(Series.builder()
                            .id(request.getSeriesId())
                            .build())
                    .build();
        }
}
