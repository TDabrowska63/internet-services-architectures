package org.example;

import model.Character;
import model.CharacterDto;
import model.TVSeries;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // ------------ ZADANIE 2 ------------
        // Tworzenie obiektów
        TVSeries DoctorWho = new TVSeries("Doctor Who", 41);
        TVSeries Vikings = new TVSeries("Vikings", 6);
        TVSeries GoodOmens = new TVSeries("Good Omens", 2);

        Character character1 = Character.builder().name("Doctor").age(2900).series(DoctorWho).build();
        Character character2 = Character.builder().name("Yaz").age(19).series(DoctorWho).build();
        Character character3 = Character.builder().name("Donna").age(35).series(DoctorWho).build();
        Character character4 = Character.builder().name("Lagherta").age(30).series(Vikings).build();
        Character character5 = Character.builder().name("Ivar").age(18).series(Vikings).build();
        Character character6 = Character.builder().name("Ragnar").age(42).series(Vikings).build();
        Character character7 = Character.builder().name("Crowley").age(6021).series(GoodOmens).build();
        Character character8 = Character.builder().name("Aziraphale").age(6021).series(GoodOmens).build();
        Character character9 = Character.builder().name("Adam").age(11).series(GoodOmens).build();

        DoctorWho.getCharacters().add(character1);
        DoctorWho.getCharacters().add(character2);
        DoctorWho.getCharacters().add(character3);
        Vikings.getCharacters().add(character4);
        Vikings.getCharacters().add(character5);
        Vikings.getCharacters().add(character6);
        GoodOmens.getCharacters().add(character7);
        GoodOmens.getCharacters().add(character8);
        GoodOmens.getCharacters().add(character9);

        List<TVSeries> seriesList = new ArrayList<>();
        seriesList.add(DoctorWho);
        seriesList.add(Vikings);
        seriesList.add(GoodOmens);

        // Drukowanie obiektów
        System.out.println("\n" + "Zadanie 2");
        seriesList.forEach(series -> {
            System.out.println(series);
            series.getCharacters().forEach(character -> {
                System.out.println("\t" + character);
            });
        });

        // ------------ ZADANIE 3 ------------
        // Set collection
        Set<Character> allCharacters = seriesList
                .stream()
                .flatMap(series -> series.getCharacters().stream())
                .collect(Collectors.toSet());

        System.out.println("\n" + "Zadanie 3"+ "\n" + "**Wszytskie elementy Set Collection**");
        allCharacters.stream()
                .forEach(System.out::println);

        // ------------ ZADANIE 4 ------------
        // Filtrowanie i Sortowanie
        System.out.println("\n" + "Zadanie 4" + "\n" + "**Postacie powyżej 20 poziomu posortowane alfabetycznie**");
        allCharacters.stream()
                .filter(character -> character.getAge() > 20)
                .sorted(Comparator.comparing(Character::getName))
                .forEach(System.out::println);

        // ------------ ZADANIE 5 ------------
        // Mapowanie do Dto
        System.out.println("\n" + "Zadanie 5");
        List<CharacterDto> dtoList = allCharacters.stream()
                .map(character -> new CharacterDto(character.getName(), character.getAge(), character.getSeries().getName()))
                .sorted()
                .collect(Collectors.toList());
        dtoList.forEach(System.out::println);

        // ------------ ZADANIE 6 ------------
        // Zapisanie kolekcji profesji do pliku binarnego
        System.out.println("\n" + "Zadanie 6");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("seriesList" +
                ".dat"))) {
            oos.writeObject(seriesList
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Obiekty zostały zserializowane");
        // Odczytanie kolekcji profesji z pliku binarnego
        List<TVSeries> readseriesList
                = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("seriesList" +
                ".dat"))) {
            readseriesList
                    = (List<TVSeries>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Wyświetlenie odczytanych profesji
        System.out.println("Obiekty zostały zdeserializowane");
        readseriesList
                .forEach(series -> {
            System.out.println(series);
            series.getCharacters().forEach(character -> {
                System.out.println("\t" + character);
            });
        });

//        // ------------ ZADANIE 7 ------------
//        // Wykonanie zadania w potokach równoległych
//        System.out.println("\n" + "Zadanie 7");
//        int customThreadPoolSize = 4; // Rozmiar puli wątków
//        ForkJoinPool customPool = new ForkJoinPool(customThreadPoolSize);
//
//        // Wykonanie zadania w potokach równoległych
//        seriesTask seriesTask = new seriesTask(seriesList
//        );
//        customPool.submit(seriesTask);
//
//        // Zamknięcie puli wątków
//        customPool.shutdown();
    }
}