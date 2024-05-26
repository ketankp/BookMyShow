package com.ketankp.bookmyshow.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaHallScreensRequestDto {

    private int cinemaHallId;
    private int screenTypeId;
    private int noOfSeats;

}
