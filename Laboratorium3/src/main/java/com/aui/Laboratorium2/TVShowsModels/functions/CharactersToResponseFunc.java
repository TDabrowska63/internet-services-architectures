package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.GetCharactersResponse;
import com.aui.Laboratorium2.TVShowsModels.Character;

import java.util.List;
import java.util.function.Function;

@Component
public class CharactersToResponseFunc implements Function<List<Character>, GetCharactersResponse>{
    @Override
    public GetCharactersResponse apply(List<Character> entities)
        {
            return GetCharactersResponse.builder()
                    .characters(entities.stream()
                            .map(character -> GetCharactersResponse.Character.builder()
                                    .id(character.getId())
                                    .name(character.getName())
                                    .build())
                            .toList())
                    .build();
        }
}
