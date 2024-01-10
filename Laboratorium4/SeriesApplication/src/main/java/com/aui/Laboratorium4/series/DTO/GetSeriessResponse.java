package com.aui.Laboratorium4.series.DTO;

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
    public static class Series
    {
        private UUID id;
        private String seriesName;
    }
    @Singular("series")
    private List<Series> seriess;
}