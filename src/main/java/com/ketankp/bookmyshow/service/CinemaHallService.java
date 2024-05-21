package com.ketankp.bookmyshow.service;

import com.ketankp.bookmyshow.dto.CinemaHallRequestDto;
import com.ketankp.bookmyshow.dto.CinemaHallResponseDto;

import java.util.List;

public interface CinemaHallService {

    public List<CinemaHallResponseDto> getAllCinemaHall();
    public CinemaHallResponseDto createCinemaHall(CinemaHallRequestDto cinemaHallRequestDto);
}
