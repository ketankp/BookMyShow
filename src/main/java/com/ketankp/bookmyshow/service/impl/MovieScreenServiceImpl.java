package com.ketankp.bookmyshow.service.impl;

import com.ketankp.bookmyshow.dto.CinemaHallScreensResponseDto;
import com.ketankp.bookmyshow.dto.MovieResponseDto;
import com.ketankp.bookmyshow.dto.MovieScreenRequestDto;
import com.ketankp.bookmyshow.dto.MovieScreenResponseDto;
import com.ketankp.bookmyshow.exception.CustomInternalServerErrorException;
import com.ketankp.bookmyshow.model.CinemaHallScreens;
import com.ketankp.bookmyshow.model.Movie;
import com.ketankp.bookmyshow.model.MovieScreenMapping;
import com.ketankp.bookmyshow.repository.MovieScreenMappingRepository;
import com.ketankp.bookmyshow.service.MovieScreenService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class MovieScreenServiceImpl implements MovieScreenService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final MovieScreenMappingRepository movieScreenMappingRepository;
    private final EntityManager entityManager;

    @Override
    public List<MovieScreenResponseDto> getMovieScreenByScreenId(int cinemaHallScreenId) {
        log.info("MovieScreenServiceImpl:getMovieScreenByScreenId method started");
        ModelMapper modelMapper = new ModelMapper();
        List<MovieScreenMapping> movieScreenMappingList = movieScreenMappingRepository.findByCinemaHallScreenId(cinemaHallScreenId);
        List<MovieScreenResponseDto> movieScreenResponseDtoList = new ArrayList<>();
        for(MovieScreenMapping obj : movieScreenMappingList){
            movieScreenResponseDtoList.add(
                    MovieScreenResponseDto.builder()
                            .cinemaHallScreen(modelMapper.map(obj.getScreenId(),CinemaHallScreensResponseDto.class))
                            .movie(modelMapper.map(obj.getMovieId(), MovieResponseDto.class))
                            .startTime(obj.getStartTime().toString())
                            .endTime(obj.getEndTime().toString())
                            .build()
            );
        }
        return movieScreenResponseDtoList;
    }

    @Override
    public MovieScreenResponseDto createMovieScreen(MovieScreenRequestDto movieScreenRequestDto) {
        try{
            ModelMapper modelMapper = new ModelMapper();

            MovieScreenMapping movieScreenMapping = new MovieScreenMapping();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date startTime = dateFormat.parse(movieScreenRequestDto.getStartTime());
            Date endTime = dateFormat.parse(movieScreenRequestDto.getEndTime());

            movieScreenMapping.setStartTime(new Timestamp(startTime.getTime()));
            movieScreenMapping.setEndTime(new Timestamp(endTime.getTime()));

            CinemaHallScreens cinemaHallScreens = new CinemaHallScreens();
            cinemaHallScreens.setCinemaHallScreensId(movieScreenRequestDto.getCinemaHallScreenId());
            movieScreenMapping.setScreenId(cinemaHallScreens);

            Movie movie = new Movie();
            movie.setMovieId(movieScreenRequestDto.getMovieId());
            movieScreenMapping.setMovieId(movie);

            movieScreenMappingRepository.saveAndFlush(movieScreenMapping);
            entityManager.refresh(movieScreenMapping);

            return MovieScreenResponseDto.builder()
                    .movieScreenMappingId(movieScreenMapping.getMovieScreenMappingId())
                    .movie(modelMapper.map(movieScreenMapping.getMovieId(),MovieResponseDto.class))
                    .cinemaHallScreen(modelMapper.map(movieScreenMapping.getScreenId(),CinemaHallScreensResponseDto.class))
                    .startTime(sdf.format(movieScreenMapping.getStartTime()))
                    .endTime(sdf.format(movieScreenMapping.getEndTime()))
                    .build();

        }catch (Exception e){
            throw new CustomInternalServerErrorException("Error while saving movie screen",e);
        }

    }

}
