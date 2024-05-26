package com.ketankp.bookmyshow.service;

import com.ketankp.bookmyshow.dto.MovieRequestDto;
import com.ketankp.bookmyshow.dto.MovieResponseDto;

import java.util.List;

public interface MovieService {
    public MovieResponseDto getMovieById(int movieId);
    public MovieResponseDto createMovie(MovieRequestDto movieRequestDto);
}
