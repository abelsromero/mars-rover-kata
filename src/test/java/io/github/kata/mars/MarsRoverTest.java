package io.github.kata.mars;


import org.assertj.core.api.Assertions;
import org.junit.Test;


public class MarsRoverTest {

    @Test
    public void should_create_planet() {
        // when
        Planet p = Planet.create(10);
        // then
        Assertions.assertThat(p).isNotNull();
    }

}
