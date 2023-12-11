package com.aui.Laboratorium4.character.functions;

import com.aui.Laboratorium4.character.DTO.PatchCharacterRequest;
import org.springframework.stereotype.Component;
import com.aui.Laboratorium4.character.entity.Character;

import java.util.function.BiFunction;

@Component
public class UpdateCharacterWithRequestFunc implements BiFunction<Character, PatchCharacterRequest, Character>{
    @Override
    public Character apply(Character entity, PatchCharacterRequest request)
        {
            return Character.builder()
                    .id(entity.getId())
                    .name(request.getName())
                    .series(entity.getSeries())
                    .build();
        }
}
