package com.aui.Laboratorium2.TVShowsModels.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchCharacterRequest {
    private String name;
    private int age;
}
