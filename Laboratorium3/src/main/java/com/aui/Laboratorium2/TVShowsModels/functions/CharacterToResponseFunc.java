package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.GetCharacterResponse;
import com.aui.Laboratorium2.TVShowsModels.Character;
import java.util.function.Function;

@Component
public class CharacterToResponseFunc implements Function<Character, GetCharacterResponse>{
    @Override
    public GetCharacterResponse apply(Character entity)
        {
            return GetCharacterResponse.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .age(entity.getAge())
                    .series(GetCharacterResponse.TVSeries.builder()
                            .id(entity.getSeries().getId())
                            .seriesName(entity.getSeries().getSeriesName())
                            .build())
                    .build();
        }
}
