package com.ketankp.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "MOVIE_SCREEN_MAPPING")
public class MovieScreenMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int movieScreenMappingId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    public Movie movieId;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    public CinemaHallScreens screenId;

    public Date startTime;
    public Date EndTime;

}
