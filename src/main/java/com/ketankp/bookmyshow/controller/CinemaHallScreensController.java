package com.ketankp.bookmyshow.controller;

import com.ketankp.bookmyshow.dto.CinemaHallScreensRequestDto;
import com.ketankp.bookmyshow.dto.CinemaHallScreensResponseDto;
import com.ketankp.bookmyshow.service.CinemaHallScreensService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cinema-hall-screens")
@Log4j2
@RequiredArgsConstructor
public class CinemaHallScreensController {

    private final CinemaHallScreensService cinemaHallScreensService;

    @GetMapping("{cinemaHallId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CinemaHallScreensResponseDto> getCinemaHallScreensByCinemaHallId(@PathVariable("cinemaHallId") int cinemaHallId){
        log.info("CinemaHallScreensController:getCinemaHallScreensByCinemaHallId method started");
        return cinemaHallScreensService.getCinemaHallScreensByCinemaHallId(cinemaHallId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaHallScreensResponseDto createCinemaHallScreens(@RequestBody CinemaHallScreensRequestDto cinemaHallScreensRequestDto){
        log.info("CinemaHallScreensController:createCinemaHallScreens method started");
        return cinemaHallScreensService.createCinemaHallScreens(cinemaHallScreensRequestDto);
    }
}
