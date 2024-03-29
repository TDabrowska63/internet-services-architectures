package com.aui.Laboratorium5.character.functions;

import com.aui.Laboratorium5.character.DTO.PatchCharacterRequest;
import org.springframework.stereotype.Component;
import com.aui.Laboratorium5.character.entity.Character;

import java.util.function.BiFunction;

@Component
public class UpdateCharacterWithRequestFunc implements BiFunction<Character, PatchCharacterRequest, Character>{
    @Override
    public Character apply(Character entity, PatchCharacterRequest request)
        {
            return Character.builder()
                    .id(entity.getId())
                    .age(request.getAge())
                    .name(request.getName())
                    .series(entity.getSeries())
                    .build();
        }
}
