package com.ketankp.bookmyshow.service;

import com.ketankp.bookmyshow.dto.CinemaHallScreensRequestDto;
import com.ketankp.bookmyshow.dto.CinemaHallScreensResponseDto;

import java.util.List;

public interface CinemaHallScreensService {
    public List<CinemaHallScreensResponseDto> getCinemaHallScreensByCinemaHallId(int cinemaHallId);
    public CinemaHallScreensResponseDto createCinemaHallScreens(CinemaHallScreensRequestDto cinemaHallScreensRequestDto);
}
