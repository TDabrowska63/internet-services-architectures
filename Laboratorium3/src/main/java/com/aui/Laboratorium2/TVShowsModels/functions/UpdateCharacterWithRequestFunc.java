package com.aui.Laboratorium2.TVShowsModels.functions;

import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.DTO.PatchCharacterRequest;
import com.aui.Laboratorium2.TVShowsModels.Character;
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
