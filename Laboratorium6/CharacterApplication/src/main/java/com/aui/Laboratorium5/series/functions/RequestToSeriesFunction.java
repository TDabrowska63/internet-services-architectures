package com.aui.Laboratorium5.series.functions;

import com.aui.Laboratorium5.series.entity.Series;
import com.aui.Laboratorium5.series.DTO.PostSeriesRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestToSeriesFunction implements Function<PostSeriesRequest, Series> {
    @Override
    public Series apply(PostSeriesRequest postSeriesRequest) {
        return Series.builder()
                .id(postSeriesRequest.getId())
                .seriesName(postSeriesRequest.getSeriesName())
                .build();
    }
}
