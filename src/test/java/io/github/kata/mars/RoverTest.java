package io.github.kata.mars;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @Test
    public void should_receive_a_command() {
        // give
        final RoverHandler rover = Planet.create(10)
            .placeRover(2, 3, Direction.E);
        final String command = "FBFBFBFB";
        // when
        rover.program(command);
        // then
        assertThat(rover.pendingCommands()).isEqualTo(command);
    }


}
