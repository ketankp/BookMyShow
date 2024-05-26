package com.ketankp.bookmyshow.service;

import com.ketankp.bookmyshow.dto.MovieScreenRequestDto;
import com.ketankp.bookmyshow.dto.MovieScreenResponseDto;

import java.util.List;

public interface MovieScreenService {
    public List<MovieScreenResponseDto> getMovieScreenByScreenId(int cinemaHallScreenId);
    public MovieScreenResponseDto createMovieScreen(MovieScreenRequestDto movieScreenRequestDto);
}
