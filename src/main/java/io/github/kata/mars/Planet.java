package io.github.kata.mars;

import lombok.Getter;

public class Planet {

    @Getter
    private final int size;

    private int[][] obstacles;
    private int obstaclesCount = 0;

    public Planet(int size) {
        this.size = size;
        obstacles = new int[size][size];
    }

    public static Planet create(int size) {
        return new Planet(size);
    }

    // TODO move elsewhere: launcher class?
    public RoverHandler placeRover(int x, int y, String direction) {
        checkPositions(x, y);
        if (!Direction.isValid(direction))
            throw new IllegalArgumentException("Direction is not valid");

        return new RoverHandler(x, y, direction, this);
    }

    private void checkPositions(int x, int y) {
        if (x < 0 || x >= size)
            throw new IllegalArgumentException("Invalid X position");
        if (y < 0 || y >= size)
            throw new IllegalArgumentException("Invalid Y position");
    }

    public void placeObstacle(int x, int y) {
        checkPositions(x, y);
        if (obstacles[x][y] == 1)
            throw new IllegalArgumentException("Cannot place obstacle: position already used");

        obstacles[x][y] = 1;
        obstaclesCount++;
    }

    public int getObstaclesCount() {
        return obstaclesCount;
    }
}
