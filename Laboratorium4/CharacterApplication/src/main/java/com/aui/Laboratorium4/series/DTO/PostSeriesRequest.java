package com.aui.Laboratorium4.series.DTO;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostSeriesRequest {
    private UUID id;
}
