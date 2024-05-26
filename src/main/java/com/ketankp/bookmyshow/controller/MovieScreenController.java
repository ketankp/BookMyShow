package com.ketankp.bookmyshow.controller;

import com.ketankp.bookmyshow.dto.MovieScreenRequestDto;
import com.ketankp.bookmyshow.dto.MovieScreenResponseDto;
import com.ketankp.bookmyshow.service.MovieScreenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie-screen")
@Log4j2
@RequiredArgsConstructor
public class MovieScreenController {

    private final MovieScreenService movieScreenService;

    @GetMapping("screen/{cinemaHallScreenId}")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieScreenResponseDto> getMovieScreenByScreenId(@PathVariable("cinemaHallScreenId") int cinemaHallScreenId){
        log.info("MovieScreenController:getMovieScreenByScreenId method started");
        return movieScreenService.getMovieScreenByScreenId(cinemaHallScreenId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieScreenResponseDto createMovieScreen(@RequestBody MovieScreenRequestDto movieScreenRequestDto){
        log.info("MovieScreenController:createMovieScreen method started");
        return movieScreenService.createMovieScreen(movieScreenRequestDto);
    }
}
