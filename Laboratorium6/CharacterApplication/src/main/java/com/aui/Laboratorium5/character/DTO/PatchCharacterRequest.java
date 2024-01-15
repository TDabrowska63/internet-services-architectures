package com.aui.Laboratorium5.character.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchCharacterRequest {
    private String name;
    private int age;
}
