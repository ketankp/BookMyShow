package com.ketankp.bookmyshow.repository;

import com.ketankp.bookmyshow.model.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall,Integer> {

}
