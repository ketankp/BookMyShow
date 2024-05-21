package com.ketankp.bookmyshow.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaHallRequestDto {

    private String cinemaHallName;
    private int noOfScreens;
    private String cinemaHallAddress;
    private String state;
    private int pincode;

}
