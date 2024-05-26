package com.ketankp.bookmyshow.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieScreenRequestDto {

    private int cinemaHallScreenId;
    private int movieId;
    private String startTime;
    private String endTime;

}
