package com.ketankp.bookmyshow.controller;

import com.ketankp.bookmyshow.dto.CinemaHallRequestDto;
import com.ketankp.bookmyshow.dto.CinemaHallResponseDto;
import com.ketankp.bookmyshow.service.CinemaHallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "cinema-hall")
@Log4j2
@RequiredArgsConstructor
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<CinemaHallResponseDto> getAllCinemaHall(){
        log.info("CinemaHallController:getAllCinemaHall method started");
        return cinemaHallService.getAllCinemaHall();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaHallResponseDto createCinemaHall(@RequestBody CinemaHallRequestDto cinemaHallRequestDto){
        log.info("CinemaHallController:createCinemaHall method started");
        return cinemaHallService.createCinemaHall(cinemaHallRequestDto);
    }

}
