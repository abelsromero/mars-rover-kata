package io.github.kata.mars;


import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {

    @Test
    public void should_create_simple_user() {
        // given
        final String userName = "a name";
        final int birthYear = 1983;
        // when
        final User user = new User(userName, LocalDate.of(birthYear, 11, 22));
        // then
        assertThat(user.getName())
            .isEqualTo(userName);
        assertThat(user.getBirthDate().getYear())
            .isEqualTo(birthYear);
        assertThat(user.getAge())
            .isEqualTo(35);
    }

    @Test
    public void lists_are_the_same() {
        // given
        final List<String> values = Arrays.asList("1", "2", "Fizz");
        // when
        // then
        assertThat(values)
            .containsSequence("1", "2", "Fizz");
        assertThat(values)
            .isEqualTo(Arrays.asList("1", "2", "Fizz"));
    }

}
