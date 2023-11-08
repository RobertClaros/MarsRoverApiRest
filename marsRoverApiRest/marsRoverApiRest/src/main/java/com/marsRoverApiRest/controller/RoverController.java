package com.marsRoverApiRest.controller;

import com.marsRoverApiRest.entity.Obstacle;
import com.marsRoverApiRest.entity.Rover;
import com.marsRoverApiRest.entity.RoverPosition;
import com.marsRoverApiRest.entity.RoverRequest;
import com.marsRoverApiRest.repository.RoverPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rover")
public class RoverController {

    @Autowired
    public RoverPositionRepository roverPositionRepository;
    @PostMapping("/start")
    public ResponseEntity<String> startRover(@RequestBody RoverRequest roverRequest) {
        int maxX = roverRequest.getMaxX();
        int maxY = roverRequest.getMaxY();
        String commands = roverRequest.getCommands();
        Rover rover = new Rover(maxX, maxY);

        Obstacle obstacle1 = Obstacle.generateRandomObstacle(maxX, maxY);
        Obstacle obstacle2 = Obstacle.generateRandomObstacle(maxX, maxY);

        rover.addObstacle(obstacle1);
        rover.addObstacle(obstacle2);

        int obstacleX1 = obstacle1.getX();
        int obstacleY1 = obstacle1.getY();
        int obstacleX2 = obstacle2.getX();
        int obstacleY2 = obstacle2.getY();

        String result = rover.executeCommands(commands);
        RoverPosition roverPosition = new RoverPosition(rover.getX(), rover.getY(), rover.getDirection(),
                commands, obstacleX1, obstacleY1, obstacleX2, obstacleY2, maxX, maxY);


        roverPositionRepository.save(roverPosition);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
