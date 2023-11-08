package com.marsRoverApiRest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Obstacle {
    private Long id;
    private int x;
    private int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Obstacle generateRandomObstacle(int maxX, int maxY) {
        Random random = new Random();
        int x = random.nextInt(maxX + 1);
        int y = random.nextInt(maxY + 1);
        return new Obstacle(x, y);
    }
}

