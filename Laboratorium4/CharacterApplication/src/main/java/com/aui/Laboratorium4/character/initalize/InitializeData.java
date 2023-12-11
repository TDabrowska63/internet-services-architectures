package com.aui.Laboratorium4.character.initalize;

import com.aui.Laboratorium4.series.entity.Series;
import com.aui.Laboratorium4.character.service.api.CharacterService;
import com.aui.Laboratorium4.series.service.api.SeriesService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aui.Laboratorium4.character.entity.Character;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean{
    // ************ EX 4 ************
    private final SeriesService seriesService;
    private final CharacterService characterService;

    @Autowired
    public InitializeData(SeriesService seriesService, CharacterService characterService) {
        this.seriesService = seriesService;
        this.characterService = characterService;
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

        /*
        TVSeries doctorWho = TVSeries.builder().id(UUID.randomUUID()).seriesName("Doctor Who").numberOfSeasons(41).build();
        TVSeries vikings = TVSeries.builder().id(UUID.randomUUID()).seriesName("Vikings").numberOfSeasons(6).build();
        TVSeries goodOmens = TVSeries.builder().id(UUID.randomUUID()).seriesName("Good Omens").numberOfSeasons(2).build();
        */
        seriesService.create(doctorWho);
        seriesService.create(vikings);
        seriesService.create(goodOmens);

        // for testing purposes initialized ID are fixed
        Character character1 = Character.builder()
                .id(UUID.fromString("4f5b6b7f-0bec-469e-8002-51bba40f0a5e"))
                .name("Doctor")
                .age(2900)
                .series(doctorWho)
                .build();
        Character character2 = Character.builder()
                .id(UUID.fromString("655c1150-77b1-436e-9003-d934a7f10167"))
                .name("Yaz")
                .age(19)
                .series(doctorWho)
                .build();
        Character character3 = Character.builder()
                .id(UUID.fromString("b6d73a3e-d749-4927-8342-a338c918f92f"))
                .name("Donna")
                .age(35)
                .series(doctorWho)
                .build();
        Character character4 = Character.builder()
                .id(UUID.fromString("565acba8-1f88-405a-bea7-5825cd19d4a1"))
                .name("Lagherta")
                .age(30)
                .series(vikings)
                .build();
        Character character5 = Character.builder()
                .id(UUID.fromString("d33af163-5f12-4064-bf18-539fd2c2e401"))
                .name("Ivar")
                .age(18)
                .series(vikings)
                .build();
        Character character6 = Character.builder()
                .id(UUID.fromString("70e3a07e-469f-47fc-864b-d06a6f05dcf2"))
                .name("Ragnar")
                .age(42)
                .series(vikings)
                .build();
        Character character7 = Character.builder()
                .id(UUID.fromString("0418d4ab-07f5-4b45-a99a-368603eed5b1"))
                .name("Crowley")
                .age(6021)
                .series(goodOmens).build();
        Character character8 = Character.builder()
                .id(UUID.fromString("355b1afa-7400-4d73-a99e-dc502a32d299"))
                .name("Aziraphale")
                .age(6021)
                .series(goodOmens)
                .build();
        Character character9 = Character.builder()
                .id(UUID.fromString("c42e98c6-ad0e-4d06-bea9-5b7a49cba6dc"))
                .name("Adam")
                .age(11)
                .series(goodOmens)
                .build();

        /*
        Character character1 = Character.builder().id(UUID.randomUUID()).name("Doctor").age(2900).series(doctorWho).build();
        Character character2 = Character.builder().id(UUID.randomUUID()).name("Yaz").age(19).series(doctorWho).build();
        Character character3 = Character.builder().id(UUID.randomUUID()).name("Donna").age(35).series(doctorWho).build();
        Character character4 = Character.builder().id(UUID.randomUUID()).name("Lagherta").age(30).series(vikings).build();
        Character character5 = Character.builder().id(UUID.randomUUID()).name("Ivar").age(18).series(vikings).build();
        Character character6 = Character.builder().id(UUID.randomUUID()).name("Ragnar").age(42).series(vikings).build();
        Character character7 = Character.builder().id(UUID.randomUUID()).name("Crowley").age(6021).series(goodOmens).build();
        Character character8 = Character.builder().id(UUID.randomUUID()).name("Aziraphale").age(6021).series(goodOmens).build();
        Character character9 = Character.builder().id(UUID.randomUUID()).name("Adam").age(11).series(goodOmens).build();
         */

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
