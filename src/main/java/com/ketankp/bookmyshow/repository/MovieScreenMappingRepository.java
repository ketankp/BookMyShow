package com.ketankp.bookmyshow.repository;

import com.ketankp.bookmyshow.model.MovieScreenMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieScreenMappingRepository extends JpaRepository<MovieScreenMapping,Integer> {

    @Query("FROM MovieScreenMapping WHERE screenId.cinemaHallScreensId = ?1")
    public List<MovieScreenMapping> findByCinemaHallScreenId(int cinemaHallScreenId);
}
