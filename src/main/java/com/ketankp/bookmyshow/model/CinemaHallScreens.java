package com.ketankp.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CINEMA_HALL_SCREENS")
public class CinemaHallScreens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int cinemaHallScreensId;

    @ManyToOne
    @JoinColumn(name = "screen_type")
    public ScreenType screenType;

    @ManyToOne
    @JoinColumn(name = "cinema_hall")
    public CinemaHall cinemaHall;

    public int noOfSeats;
}
