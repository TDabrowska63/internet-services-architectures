package com.aui.Laboratorium2.TVShowsModels.DTO;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetSeriessResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TVSeries
    {
        private UUID id;
        private String seriesName;
    }
    @Singular("series")
    private List<TVSeries> series;
}
