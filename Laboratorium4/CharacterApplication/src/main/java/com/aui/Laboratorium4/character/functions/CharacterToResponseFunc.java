package com.aui.Laboratorium4.character.functions;

import com.aui.Laboratorium4.character.DTO.GetCharacterResponse;
import com.aui.Laboratorium4.character.entity.Character;
import org.springframework.stereotype.Component;

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
                    .series(GetCharacterResponse.Series.builder()
                            .id(entity.getSeries().getId())
                            .seriesName(entity.getSeries().getSeriesName())
                            .build())
                    .build();
        }
}
