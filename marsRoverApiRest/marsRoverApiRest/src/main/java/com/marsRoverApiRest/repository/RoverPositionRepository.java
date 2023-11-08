package com.marsRoverApiRest.repository;

import com.marsRoverApiRest.entity.RoverPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoverPositionRepository extends JpaRepository<RoverPosition, Long> {

}