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

    @Test
    public void should_execute_a_instruction_and_move() {
        // give
        final RoverHandler rover = Planet.create(10)
            .placeRover(2, 3, Direction.E);
        final String command = "fblr";
        rover.program(command);
        // when
        rover.execute(1);
        //
        assertThat(rover.pendingCommands()).isEqualTo(command.substring(1));
        assertThat(rover.getX()).isEqualTo(3);
        assertThat(rover.getY()).isEqualTo(3);
        assertThat(rover.getDirection()).isEqualTo(Direction.E);
    }

    @Test
    public void should_execute_two_instructions_and_rotate_right() {
        // give
        final RoverHandler rover = Planet.create(10)
            .placeRover(2, 3, Direction.E);
        final String command = "rrrr";
        rover.program(command);
        // when
        rover.execute(2);
        //
        assertThat(rover.pendingCommands()).isEqualTo(command.substring(2));
        assertThat(rover.getX()).isEqualTo(2);
        assertThat(rover.getY()).isEqualTo(3);
        assertThat(rover.getDirection()).isEqualTo(Direction.W);
    }

    @Test
    public void should_execute_instructions_and_rotate() {
        // give
        final RoverHandler rover = Planet.create(10)
            .placeRover(2, 3, Direction.N);
        final String command = "llrrrlrr";
        rover.program(command);
        // when
        rover.execute(command.length());
        //
        assertThat(rover.pendingCommands()).isEqualTo("");
        assertThat(rover.getX()).isEqualTo(2);
        assertThat(rover.getY()).isEqualTo(3);
        assertThat(rover.getDirection()).isEqualTo(Direction.S);
    }

    @Test
    public void should_wrap_position() {
        // give
        final RoverHandler rover = Planet.create(5)
            .placeRover(2, 2, Direction.S);
        final String command = "fff";
        rover.program(command);
        // when
        rover.execute(command.length());
        //
        assertThat(rover.pendingCommands()).isEqualTo("");
        assertThat(rover.getX()).isEqualTo(2);
        assertThat(rover.getY()).isEqualTo(4);
        assertThat(rover.getDirection()).isEqualTo(Direction.S);
    }

    @Test
    public void should_wrap_position_complex() {
        // give
        final RoverHandler rover = Planet.create(5)
            .placeRover(2, 2, Direction.S);
        final String command = "ffflbbb";
        rover.program(command);
        // when
        rover.execute(command.length());
        //
        assertThat(rover.pendingCommands()).isEqualTo("");
        assertThat(rover.getX()).isEqualTo(4);
        assertThat(rover.getY()).isEqualTo(4);
        assertThat(rover.getDirection()).isEqualTo(Direction.E);
    }
}
