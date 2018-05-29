package io.github.kata.mars;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @Test
    public void should_receive_a_command() {
        // give
        final RoverHandler rover = Planet.create(10)
            .placeRover(2, 3, Direction.E);
        final String command = "fbfbfbfbfbf";
        // when
        rover.program(command);
        // then
        assertThat(rover.pendingCommands()).isEqualTo(command);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_validate_f_and_b_instructions() {
        // give
        final RoverHandler rover = Planet.create(10)
            .placeRover(2, 3, Direction.E);
        final String command = "fbfbfbxfbfbf";
        // when
        rover.program(command);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_validate_l_and_r_instructions() {
        // give
        final RoverHandler rover = Planet.create(10)
            .placeRover(2, 3, Direction.E);
        final String command = "lrlrlcrll";
        // when
        rover.program(command);
    }

    @Test
    public void should_receive_a_command_with_all_instructions() {
        // give
        final RoverHandler rover = Planet.create(10)
            .placeRover(2, 3, Direction.E);
        final String command = "fblr";
        // when
        rover.program(command);
    }
}
