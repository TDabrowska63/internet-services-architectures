package model;

import java.io.Serializable;
import java.util.Objects;
import lombok.Builder;

@Builder
public class Character implements Serializable {
    private String name;
    private int age;
    private TVSeries series;

    // Konstruktor
    private Character(String name, int level, TVSeries series) {
        this.name = name;
        this.age = level;
        this.series = series;
    }

    // Gettery i Settery
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public TVSeries getSeries() {
        return series;
    }

    // Metoda equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
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

//    public static class Builder {
//        private String name;
//        private int age;
//        private TVSeries series;
//
//        public Builder() {}
//
//        public Builder withName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder withLevel(int age) {
//            this.age = age;
//            return this;
//        }
//
//        public Builder withProfession(TVSeries series) {
//            this.series = series;
//            return this;
//        }
//
//        public Character build() {
//            return new Character(name, age, series);
//        }
//    }
}
