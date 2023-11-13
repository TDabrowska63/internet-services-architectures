package com.aui.Laboratorium2.DTO;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetMultipleCharactersResponse {
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
