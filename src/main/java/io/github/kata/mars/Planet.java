package io.github.kata.mars;

public class Planet {

    private final int size;

    private int roverX;
    private int roverY;

    public Planet(int size) {
        this.size = size;
    }

    public static Planet create(int size) {
        return new Planet(size);
    }

    public void placeRover(int x, int y) {
        if (x < 0 || x >= size)
            throw new IllegalArgumentException("Invalid X position");
        if (y < 0 || y >= size)
            throw new IllegalArgumentException("Invalid Y position");

        this.roverX = x;
        this.roverY = y;
    }
}
