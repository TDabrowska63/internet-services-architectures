package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TVSeries implements Serializable{
    private String name;
    private int baseArmor;
    private List<Character> characters;

    // Konstruktor
    public TVSeries(String name, int baseArmor) {
        this.name = name;
        this.baseArmor = baseArmor;
        this.characters = new ArrayList<>();
    }

    // Gettery i Settery
    public String getName() {
        return name;
    }

    public int getBaseArmor() {
        return baseArmor;
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
        return baseArmor == that.baseArmor && Objects.equals(name, that.name);
    }

    // Metoda hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, baseArmor);
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Profession{" +
                "name='" + name + '\'' +
                ", baseArmor=" + baseArmor +
                '}';
    }
}

