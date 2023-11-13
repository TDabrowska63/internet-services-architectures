package com.aui.Laboratorium2.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchSeriesRequest {
    private String seriesName;
    private int numberOfSeasons;
}
