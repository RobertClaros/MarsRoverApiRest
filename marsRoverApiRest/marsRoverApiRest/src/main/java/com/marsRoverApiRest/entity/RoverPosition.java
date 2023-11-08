package com.marsRoverApiRest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rover_position")
public class RoverPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rover_x")
    private int roverX;

    @Column(name = "rover_y")
    private int roverY;

    @Enumerated(EnumType.STRING)
    private Direction direction;

    // Nuevos campos para almacenar comandos y coordenadas de obstáculos
    private String commands;

    @Column(name = "obstacle_x")
    private int obstacleX;

    @Column(name = "obstacle_y")
    private int obstacleY;

    @Column(name = "obstacle_x2")
    private int obstacleX2;

    @Column(name = "obstacle_y2")
    private int obstacleY2;

    @Column(name = "board_max_x")
    private int boardMaxX;

    @Column(name = "board_max_y")
    private int boardMaxY;

    public RoverPosition(int roverX, int roverY, Direction direction, String commands, int obstacleX1, int obstacleY1, int obstacleX2, int obstacleY2, int boardMaxX, int boardMaxY) {
        this.roverX = roverX;
        this.roverY = roverY;
        this.direction = direction;
        this.commands = commands;
        this.obstacleX = obstacleX1;
        this.obstacleY = obstacleY1;
        this.obstacleX2 = obstacleX2;
        this.obstacleY2 = obstacleY2;
        this.boardMaxX = boardMaxX;
        this.boardMaxY = boardMaxY;
    }

}