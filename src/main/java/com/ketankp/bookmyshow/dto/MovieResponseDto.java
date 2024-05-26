package com.ketankp.bookmyshow.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponseDto {
    private int movieId;
    private String movieName;
    private String movieGenre;
    private int movieDurationInMinutes;
    private String date;
}
