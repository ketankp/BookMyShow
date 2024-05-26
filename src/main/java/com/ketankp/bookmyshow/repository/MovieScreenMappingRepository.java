package com.ketankp.bookmyshow.repository;

import com.ketankp.bookmyshow.model.MovieScreenMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface MovieScreenMappingRepository extends JpaRepository<MovieScreenMapping,Integer> {

    @Query("FROM MovieScreenMapping WHERE screenId.cinemaHallScreensId = ?1")
    public List<MovieScreenMapping> findByCinemaHallScreenId(int cinemaHallScreenId);

    @Query("FROM MovieScreenMapping WHERE screenId.cinemaHallScreensId = ?1\r\n" +
            "AND ((?2 > startTime and ?2 < endTime)\r\n" +
            "OR (?3 > startTime and ?3 < endTime)\r\n" +
            "OR (?2 < startTime and ?3 > endTime))")
    public List<MovieScreenMapping> findOverlappingScreen(int cinemaHallScreenId, Timestamp startTime, Timestamp endTime);
}
