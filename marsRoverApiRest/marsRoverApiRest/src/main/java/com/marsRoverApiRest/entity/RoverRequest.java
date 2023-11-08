package com.marsRoverApiRest.entity;

import lombok.Data;

@Data
public class RoverRequest {
    private int maxX;
    private int maxY;
    private String commands;

}

