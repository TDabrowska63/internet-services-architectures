package com.aui.Laboratorium5.series.initialize;

import com.aui.Laboratorium5.series.entity.Series;
import com.aui.Laboratorium5.series.service.api.SeriesService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final SeriesService seriesService;

    @Autowired
    public InitializeData(SeriesService seriesService){
        this.seriesService=seriesService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        Series doctorWho = Series.builder()
                .id(UUID.fromString("d0441997-9c76-4f94-a575-1f935084c3cb"))
                .seriesName("Doctor Who")
                .numberOfSeasons(41)
                .build();
        Series vikings = Series.builder()
                .id(UUID.fromString("8678e163-8228-4d8a-81f0-b14b19297032"))
                .seriesName("Vikings")
                .numberOfSeasons(6)
                .build();
        Series goodOmens = Series.builder()
                .id(UUID.fromString("df69c0c6-884c-42e2-985d-7663506a2294"))
                .seriesName("Good Omens")
                .numberOfSeasons(2)
                .build();
        seriesService.create(doctorWho);
        seriesService.create(vikings);
        seriesService.create(goodOmens);
    }
}
