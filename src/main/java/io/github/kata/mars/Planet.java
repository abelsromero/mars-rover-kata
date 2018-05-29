package io.github.kata.mars;

import lombok.Getter;

public class Planet {

    @Getter
    private final int size;

    public Planet(int size) {
        this.size = size;
    }

    public static Planet create(int size) {
        return new Planet(size);
    }

    // TODO move elsewhere: launcher class?
    public RoverHandler placeRover(int x, int y, String direction) {
        if (x < 0 || x >= size)
            throw new IllegalArgumentException("Invalid X position");
        if (y < 0 || y >= size)
            throw new IllegalArgumentException("Invalid Y position");
        if (!Direction.isValid(direction))
            throw new IllegalArgumentException("Direction is not valid");

        return new RoverHandler(x, y, direction, this);
    }

}
