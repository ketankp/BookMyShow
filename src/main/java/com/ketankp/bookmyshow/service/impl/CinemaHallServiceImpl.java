package com.ketankp.bookmyshow.service.impl;

import com.ketankp.bookmyshow.dto.CinemaHallRequestDto;
import com.ketankp.bookmyshow.dto.CinemaHallResponseDto;
import com.ketankp.bookmyshow.model.CinemaHall;
import com.ketankp.bookmyshow.repository.CinemaHallRepository;
import com.ketankp.bookmyshow.service.CinemaHallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallRepository cinemaHallRepository;

    @Override
    public List<CinemaHallResponseDto> getAllCinemaHall() {
        log.info("CinemaHallServiceImpl:getAllCinemaHall method started");
        ModelMapper mapper = new ModelMapper();
        return mapper.map(cinemaHallRepository.findAll(),new TypeToken<List<CinemaHallResponseDto>>(){}.getType());
    }

    @Override
    public CinemaHallResponseDto createCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        log.info("CinemaHallServiceImpl:createCinemaHall method started");
        ModelMapper modelMapper = new ModelMapper();
        CinemaHall cinemaHall = modelMapper.map(cinemaHallRequestDto,CinemaHall.class);
        cinemaHallRepository.save(cinemaHall);
        return modelMapper.map(cinemaHall,CinemaHallResponseDto.class);
    }

}
