package com.aui.Laboratorium4.character.entity;

import com.aui.Laboratorium4.series.entity.Series;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="characters")
public class Character implements Serializable,Comparable<Character>{
    @Id
    private UUID id;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    int age;
    @ManyToOne
    @JoinColumn(name = "series")
    @EqualsAndHashCode.Exclude
    Series series;

    @Override
    public String toString() {
        return "\nCharacter{seriesName='" + this.name + "', age=" + this.age + ", series=" + this.series + "}";
    }

    @Override
    public int compareTo(Character o) {
        if(this.getName().compareTo(o.getName())<0)
            return -1;
        else if (this.getName().compareTo(o.getName())>0) {
            return 1;
        }
        if(this.getAge() - o.getAge() < 0)
            return -1;
        else if (this.getAge() - o.getAge() > 0) {
            return 1;
        }
        return 0;
    }
}
