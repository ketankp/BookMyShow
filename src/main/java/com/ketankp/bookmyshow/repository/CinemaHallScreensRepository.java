package com.ketankp.bookmyshow.repository;

import com.ketankp.bookmyshow.model.CinemaHallScreens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaHallScreensRepository extends JpaRepository<CinemaHallScreens,Integer> {

    @Query("FROM CinemaHallScreens WHERE cinemaHall.cinemaHallId = ?1")
    public List<CinemaHallScreens> findByCinemaHall(int id);
}
