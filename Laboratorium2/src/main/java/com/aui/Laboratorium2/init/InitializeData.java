package com.aui.Laboratorium2.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import com.aui.Laboratorium2.TVShowsModels.services.TVSeriesService;
import com.aui.Laboratorium2.TVShowsModels.Character;
import com.aui.Laboratorium2.TVShowsModels.services.CharacterService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean{
    // ************ EX 4 ************
    private final TVSeriesService seriesService;
    private final CharacterService characterService;

    @Autowired
    public InitializeData(TVSeriesService seriesService, CharacterService characterService) {
        this.seriesService = seriesService;
        this.characterService = characterService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TVSeries doctorWho = TVSeries.builder().id(UUID.randomUUID()).seriesName("Doctor Who").numberOfSeasons(41).build();
        TVSeries vikings = TVSeries.builder().id(UUID.randomUUID()).seriesName("Vikings").numberOfSeasons(6).build();
        TVSeries goodOmens = TVSeries.builder().id(UUID.randomUUID()).seriesName("Good Omens").numberOfSeasons(2).build();
        seriesService.create(doctorWho);
        seriesService.create(vikings);
        seriesService.create(goodOmens);

        Character character1 = Character.builder().id(UUID.randomUUID()).name("Doctor").age(2900).series(doctorWho).build();
        Character character2 = Character.builder().id(UUID.randomUUID()).name("Yaz").age(19).series(doctorWho).build();
        Character character3 = Character.builder().id(UUID.randomUUID()).name("Donna").age(35).series(doctorWho).build();
        Character character4 = Character.builder().id(UUID.randomUUID()).name("Lagherta").age(30).series(vikings).build();
        Character character5 = Character.builder().id(UUID.randomUUID()).name("Ivar").age(18).series(vikings).build();
        Character character6 = Character.builder().id(UUID.randomUUID()).name("Ragnar").age(42).series(vikings).build();
        Character character7 = Character.builder().id(UUID.randomUUID()).name("Crowley").age(6021).series(goodOmens).build();
        Character character8 = Character.builder().id(UUID.randomUUID()).name("Aziraphale").age(6021).series(goodOmens).build();
        Character character9 = Character.builder().id(UUID.randomUUID()).name("Adam").age(11).series(goodOmens).build();

        characterService.create(character1);
        characterService.create(character2);
        characterService.create(character3);
        characterService.create(character4);
        characterService.create(character5);
        characterService.create(character6);
        characterService.create(character7);
        characterService.create(character8);
        characterService.create(character9);

    }
}
