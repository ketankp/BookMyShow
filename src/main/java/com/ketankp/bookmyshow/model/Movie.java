package com.ketankp.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int movieId;

    public String movieName;
    public String movieGenre;
    public int movieDurationInMinutes;

}
