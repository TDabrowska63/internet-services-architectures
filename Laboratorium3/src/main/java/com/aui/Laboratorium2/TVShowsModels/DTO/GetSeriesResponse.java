package com.aui.Laboratorium2.TVShowsModels.DTO;

import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetSeriesResponse {
    private UUID id;
    private String seriesName;
    private int numberOfSeasons;
}
