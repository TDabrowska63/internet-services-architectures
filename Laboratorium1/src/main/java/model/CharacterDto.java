package model;

import java.io.Serializable;
import java.util.Objects;

public class CharacterDto implements Comparable<CharacterDto>, Serializable {
    private String name;
    private int age;
    private String series;

    // Konstruktor
    public CharacterDto(String name, int age, String series) {
        this.name = name;
        this.age = age;
        this.series = CharacterDto.this.series;
    }

    // Gettery i Settery
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getseries() {
        return series;
    }

    // Metoda equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterDto)) return false;
        CharacterDto character = (CharacterDto) o;
        return age == character.age && Objects.equals(name, character.name) && Objects.equals(series, character.series);
    }

    // Metoda hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, age, series);
    }


    // Metoda toString
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", series=" + series +
                '}';
    }

    @Override
    public int compareTo(CharacterDto o) {
        return 0;
    }
}
