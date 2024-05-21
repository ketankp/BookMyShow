package com.ketankp.bookmyshow.service.impl;

import com.ketankp.bookmyshow.dto.CinemaHallRequestDto;
import com.ketankp.bookmyshow.dto.CinemaHallResponseDto;
import com.ketankp.bookmyshow.model.CinemaHall;
import com.ketankp.bookmyshow.repository.CinemaHallRepository;
import com.ketankp.bookmyshow.service.CinemaHallService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallRepository cinemaHallRepository;

    @Override
    public List<CinemaHallResponseDto> getAllCinemaHall() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(cinemaHallRepository.findAll(),new TypeToken<List<CinemaHallResponseDto>>(){}.getType());
    }

    @Override
    public CinemaHallResponseDto createCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        CinemaHall cinemaHall = modelMapper.map(cinemaHallRequestDto,CinemaHall.class);
        cinemaHallRepository.save(cinemaHall);
        return modelMapper.map(cinemaHall,CinemaHallResponseDto.class);
    }

}
