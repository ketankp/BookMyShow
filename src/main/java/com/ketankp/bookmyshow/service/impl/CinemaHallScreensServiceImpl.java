package com.ketankp.bookmyshow.service.impl;

import com.ketankp.bookmyshow.dto.CinemaHallScreensRequestDto;
import com.ketankp.bookmyshow.dto.CinemaHallScreensResponseDto;
import com.ketankp.bookmyshow.exception.CustomBadRequestException;
import com.ketankp.bookmyshow.model.CinemaHall;
import com.ketankp.bookmyshow.model.CinemaHallScreens;
import com.ketankp.bookmyshow.model.ScreenType;
import com.ketankp.bookmyshow.repository.CinemaHallRepository;
import com.ketankp.bookmyshow.repository.CinemaHallScreensRepository;
import com.ketankp.bookmyshow.service.CinemaHallScreensService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class CinemaHallScreensServiceImpl implements CinemaHallScreensService {

    private final CinemaHallScreensRepository cinemaHallScreensRepository;
    private final EntityManager entityManager;
    private final CinemaHallRepository cinemaHallRepository;

    @Override
    public List<CinemaHallScreensResponseDto> getCinemaHallScreensByCinemaHallId(int cinemaHallId) {
        log.info("CinemaHallScreensServiceImpl:getCinemaHallScreensByCinemaHallId");
        ModelMapper modelMapper = new ModelMapper();
        List<CinemaHallScreens> cinemaHallScreensList = cinemaHallScreensRepository.findByCinemaHall(cinemaHallId);
        List<CinemaHallScreensResponseDto> cinemaHallScreensResponseDto = new ArrayList<>();
        for(CinemaHallScreens obj : cinemaHallScreensList){
            cinemaHallScreensResponseDto.add(
                    CinemaHallScreensResponseDto.builder()
                            .cinemaHallScreensId(obj.getCinemaHallScreensId())
                            .noOfSeats(obj.getNoOfSeats())
                            .screenType(obj.getScreenType().getScreenTypeName())
                            .build()
            );
        }
        return cinemaHallScreensResponseDto;
    }

    @Override
    public CinemaHallScreensResponseDto createCinemaHallScreens(CinemaHallScreensRequestDto cinemaHallScreensRequestDto) {
        log.info("CinemaHallScreensServiceImpl:createCinemaHallScreens method started");
        CinemaHall cinemaHall = cinemaHallRepository.findById(cinemaHallScreensRequestDto.getCinemaHallId()).orElse(null);
        List<CinemaHallScreens> cinemaHallScreensList = cinemaHallScreensRepository.findByCinemaHall(cinemaHall.getCinemaHallId());
        if(cinemaHallScreensList.size() < cinemaHall.getNoOfScreens()){
            CinemaHallScreens cinemaHallScreens = new CinemaHallScreens();
            cinemaHallScreens.setNoOfSeats(cinemaHallScreensRequestDto.getNoOfSeats());

            ScreenType screenType = new ScreenType();
            screenType.setScreenTypeId(cinemaHallScreensRequestDto.getScreenTypeId());

            cinemaHallScreens.setCinemaHall(cinemaHall);
            cinemaHallScreens.setScreenType(screenType);

            cinemaHallScreensRepository.saveAndFlush(cinemaHallScreens);
            entityManager.refresh(cinemaHallScreens);
            return CinemaHallScreensResponseDto.builder()
                    .noOfSeats(cinemaHallScreens.getNoOfSeats())
                    .screenType(cinemaHallScreens.getScreenType().getScreenTypeName())
                    .build();
        }else{
            throw new CustomBadRequestException("Cannot add screens more than " + cinemaHall.getNoOfScreens(),"");
        }
    }

}
