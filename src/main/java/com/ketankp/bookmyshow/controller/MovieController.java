package com.ketankp.bookmyshow.controller;

import com.ketankp.bookmyshow.dto.MovieRequestDto;
import com.ketankp.bookmyshow.dto.MovieResponseDto;
import com.ketankp.bookmyshow.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieResponseDto getMovieById(@PathVariable("id") int movieId){
        log.info("MovieController:getMovieById method started");
        return movieService.getMovieById(movieId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto createMovie(@RequestBody MovieRequestDto movieRequestDto){
        log.info("MovieController:createMovie method started");
        return movieService.createMovie(movieRequestDto);
    }
}
