package com.aui.Laboratorium2.TVShowsModels;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
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
    @Column(name = "series_name")
    String seriesName;
    @Column(name = "number_of_seasons")
    int numberOfSeasons;
    @OneToMany(mappedBy = "series")
    @Basic(fetch = FetchType.LAZY)
    @ToString.Exclude
    @Singular
    @EqualsAndHashCode.Exclude
    List<Character> characters;

    @Override
    public int compareTo(TVSeries o) {
        if(this.getSeriesName().compareTo(o.getSeriesName())<0)
            return -1;
        else if (this.getSeriesName().compareTo(o.getSeriesName())>0) {
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
