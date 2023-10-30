package com.aui.Laboratorium2.TVShowsModels;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tvseries")
public class TVSeries implements Serializable,Comparable<TVSeries>{
    @Id
    @ToString.Exclude
    private UUID id;
    @Column(name = "name")
    String name;
    @Column(name = "numberOfSeasons")
    int numberOfSeasons;
    @OneToMany(mappedBy = "series")
    @Basic(fetch = FetchType.LAZY)
    @ToString.Exclude
    @Singular
    @EqualsAndHashCode.Exclude
    List<Character> characters;

    @Override
    public int compareTo(TVSeries o) {
        if(this.getName().compareTo(o.getName())<0)
            return -1;
        else if (this.getName().compareTo(o.getName())>0) {
            return 1;
        }
        if(this.getNumberOfSeasons() - o.getNumberOfSeasons() < 0)
            return -1;
        else if (this.getNumberOfSeasons() - o.getNumberOfSeasons() > 0) {
            return 1;
        }
        return 0;
    }
}
