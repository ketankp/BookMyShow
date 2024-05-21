package com.ketankp.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CINEMA_HALL")
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int cinemaHallId;

    public String cinemaHallName;
    public int noOfScreens;
    public String cinemaHallAddress;
    public String state;
    public int pincode;

}
