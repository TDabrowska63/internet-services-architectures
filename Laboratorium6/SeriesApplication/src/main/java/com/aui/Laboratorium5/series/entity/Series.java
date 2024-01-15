package com.aui.Laboratorium5.series.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tvseries")
public class Series implements Serializable,Comparable<Series>{
    @Id
    @ToString.Exclude
    private UUID id;
    @Column(name = "series_name")
    String seriesName;
    @Column(name = "number_of_seasons")
    int numberOfSeasons;


    @Override
    public int compareTo(Series o) {
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
