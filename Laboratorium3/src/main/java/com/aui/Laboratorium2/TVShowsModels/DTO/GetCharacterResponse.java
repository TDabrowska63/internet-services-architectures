package com.aui.Laboratorium2.TVShowsModels.DTO;

import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetCharacterResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TVSeries {
        private UUID id;
        private String seriesName;

    }
    private UUID id;
    private String name;
    private int age;
    private TVSeries series;
}
