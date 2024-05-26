package com.ketankp.bookmyshow.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieScreenResponseDto {
    private int movieScreenMappingId;
    private MovieResponseDto movie;
    private CinemaHallScreensResponseDto cinemaHallScreen;
    private String startTime;
    private String endTime;
}
