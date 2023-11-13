package com.aui.Laboratorium2.TVShowsModels.DTO;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetCharactersResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Character
    {
        private UUID id;
        private String name;
    }
    @Singular
    private List<Character> characters;
}
