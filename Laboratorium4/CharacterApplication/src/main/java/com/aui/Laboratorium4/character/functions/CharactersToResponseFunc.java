package com.aui.Laboratorium4.character.functions;

import com.aui.Laboratorium4.character.entity.Character;
import com.aui.Laboratorium4.character.DTO.GetCharactersResponse;
import org.springframework.stereotype.Component;

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
