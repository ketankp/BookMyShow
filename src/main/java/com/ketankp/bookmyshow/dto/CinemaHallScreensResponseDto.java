package com.ketankp.bookmyshow.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaHallScreensResponseDto {
    private int cinemaHallScreensId;
    private String screenType;
    private Integer noOfSeats;
}
