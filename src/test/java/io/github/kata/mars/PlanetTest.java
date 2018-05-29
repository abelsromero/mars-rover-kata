package io.github.kata.mars;


import org.assertj.core.api.Assertions;
import org.junit.Test;


public class PlanetTest {

    @Test
    public void should_create_planet() {
        // when
        Planet p = Planet.create(10);
        // then
        Assertions.assertThat(p).isNotNull();
    }

    @Test
    public void should_place_rover() {
        // when
        Planet p = Planet.create(10);
        p.placeRover(2, 3);
        // then

        Assertions.assertThat(p).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_rover_x_is_negative() {
        // when
        Planet p = Planet.create(10);
        p.placeRover(-1, 3);
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_rover_y_is_negative() {
        // when
        Planet p = Planet.create(10);
        p.placeRover(4, -1);
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_rover_x_is_outofbound() {
        // when
        final int size = 10;
        Planet p = Planet.create(size);
        p.placeRover(size + 1, 5);
        // then
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_fail_when_rover_y_is_outofbound() {
        // when
        final int size = 10;
        Planet p = Planet.create(size);
        p.placeRover(2, size + 1);
        // then
    }

}
