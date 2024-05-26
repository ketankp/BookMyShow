package com.ketankp.bookmyshow.service.impl;

import com.ketankp.bookmyshow.dto.MovieRequestDto;
import com.ketankp.bookmyshow.dto.MovieResponseDto;
import com.ketankp.bookmyshow.exception.CustomNotFoundException;
import com.ketankp.bookmyshow.model.Movie;
import com.ketankp.bookmyshow.repository.MovieRepository;
import com.ketankp.bookmyshow.service.MovieService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final EntityManager entityManager;

    @Override
    public MovieResponseDto getMovieById(int movieId) {
        ModelMapper modelMapper = new ModelMapper();
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if(movie == null){
            throw new CustomNotFoundException("Movie with id " + movieId + " not found","");
        }else{
            return modelMapper.map(movieRepository.findById(movieId),MovieResponseDto.class);
        }

    }

    @Override
    public MovieResponseDto createMovie(MovieRequestDto movieRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Movie movie = movieRepository.saveAndFlush(modelMapper.map(movieRequestDto,Movie.class));
        entityManager.refresh(movie);
        return modelMapper.map(movie,MovieResponseDto.class);
    }

}
