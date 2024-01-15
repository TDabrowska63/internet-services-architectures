package com.aui.Laboratorium5.series.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchSeriesRequest {
    private String seriesName;
    private int numberOfSeasons;
}

