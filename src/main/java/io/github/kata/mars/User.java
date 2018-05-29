package io.github.kata.mars;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {

    private String name;
    private final LocalDate birthDate;

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}
