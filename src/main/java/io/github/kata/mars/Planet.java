package io.github.kata.mars;

public class Planet {

    private final int size;

    public Planet(int size) {
        this.size = size;
    }

    public static Planet create(int size) {
        return new Planet(size);
    }

}
