package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TVSeries implements Serializable{
    private String name;
    private int numberOfSeasons;
    private List<Character> characters;

    // Konstruktor
    public TVSeries(String name, int numberOfSeasons) {
        this.name = name;
        this.numberOfSeasons = numberOfSeasons;
        this.characters = new ArrayList<>();
    }

    // Gettery i Settery
    public String getName() {
        return name;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    // Metody equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TVSeries that = (TVSeries) o;
        return numberOfSeasons == that.numberOfSeasons && Objects.equals(name, that.name);
    }

    // Metoda hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfSeasons);
    }

    // Metoda toString
    @Override
    public String toString() {
        return "TVSeries{" +
                "name='" + name + '\'' +
                ", numberOfSeasons=" + numberOfSeasons +
                '}';
    }
}

