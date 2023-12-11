package com.aui.Laboratorium4.series.function;

import com.aui.Laboratorium4.series.DTO.PostSeriesRequest;
import com.aui.Laboratorium4.series.entity.Series;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SeriesToRequestFunc implements Function<Series, PostSeriesRequest> {
    @Override
    public PostSeriesRequest apply(Series series) {
        return PostSeriesRequest
                .builder()
                .id(series.getId())
                .build();
    }
}
