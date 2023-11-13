package com.aui.Laboratorium2.TVShowsModels.DTO;

import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutCharacterRequest {
    private String name;
    private int age;
    private UUID seriesId;
}
