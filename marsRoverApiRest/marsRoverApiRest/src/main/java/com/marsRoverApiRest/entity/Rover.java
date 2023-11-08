package com.marsRoverApiRest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Rover {

    private Long id;
    private Direction direction;
    private List<Obstacle> obstacleList = new ArrayList<>();
    private int x;
    private int y;
    private final int maxX;
    private final int maxY;

    public Rover(int maxX, int maxY) {
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public String executeCommands(String commands) {
        StringBuilder result = new StringBuilder();
        for (char command : commands.toCharArray()) {
            if (command == 'f') {
                moveForward();
            } else if (command == 'b') {
                moveBackward();
            } else if (command == 'l') {
                turnLeft();
            } else if (command == 'r') {
                turnRight();
            }

        }
        result.append("Obstacles position:\n");
        for (Obstacle obstacle : obstacleList) {
            result.append("X: ").append(obstacle.getX()).append(", Y: ").append(obstacle.getY()).append("\n");
        }

        result.append("Position: ").append(x).append(",").append(y).append(" Direction: ").append(direction).append("\n");
        return result.toString();
    }


    private void moveForward() {
        int newX = x;
        int newY = y;
        switch (direction) {
            case NORTH:
                newY = (y + 1) % (maxY + 1);
                break;
            case EAST:
                newX = (x + 1) % (maxX + 1);
                break;
            case SOUTH:
                newY = (y - 1 + maxY + 1) % (maxY + 1);
                break;
            case WEST:
                newX = (x - 1 + maxX + 1) % (maxX + 1);
                break;
        }
        if (!isObstacle(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    private void moveBackward() {
        int newX = x;
        int newY = y;
        switch (direction) {
            case NORTH:
                newY = (y - 1 + maxY + 1) % (maxY + 1);
                break;
            case EAST:
                newX = (x - 1 + maxX + 1) % (maxX + 1);
                break;
            case SOUTH:
                newY = (y + 1) % (maxY + 1);
                break;
            case WEST:
                newX = (x + 1) % (maxX + 1);
                break;
        }
        if (!isObstacle(newX, newY)) {
            x = newX;
            y = newY;
        }
    }


    private void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    public void addObstacle(Obstacle obstacle) {
        obstacleList.add(obstacle);
    }
    public List<Obstacle> getObstacles() {
        return obstacleList;
    }


    public boolean isObstacle(int x, int y) {
        for (Obstacle obstacle : obstacleList) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                return true;
            }
        }
        return false;
    }


}
