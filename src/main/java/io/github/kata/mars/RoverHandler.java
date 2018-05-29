package io.github.kata.mars;

import lombok.Getter;

public class RoverHandler {

    private final Planet planet;

    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private String direction;

    private String command;
    private int cursor = 0;

    public RoverHandler(int x, int y, String direction, Planet planet) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.planet = planet;
    }

    public void program(String command) {
        for (char c : command.toCharArray()) {
            if (!isValidInstruction(c))
                throw new IllegalArgumentException("Invalid instruction found: " + c);
        }
        this.command = command;
    }

    private boolean isValidInstruction(char c) {
        return c == 'f' || c == 'b' || c == 'l' || c == 'r';
    }

    public String pendingCommands() {
        return command.substring(cursor);
    }

    public void execute(final int instructions) {
        for (int i = 0; i < instructions; i++) {
            char instruction = command.charAt(cursor);
            if (isMoveInstruction(instruction)) {
                move(instruction);
            }
            else if (isRotateinstruction(instruction)) {
                rotate(instruction);
            }
            cursor++;
        }
    }

    private void rotate(char instruction) {
        final String directions = Direction.N + Direction.E + Direction.S + Direction.W;
        int currentDirectionPos = directions.indexOf(direction);
        // 3 = -1+4; to ensure positive module
        this.direction = String.valueOf(directions.charAt((currentDirectionPos + (instruction == 'l' ? 3 : 1)) % 4));
    }

    private boolean isRotateinstruction(char instruction) {
        return instruction == 'l' || instruction == 'r';
    }

    private void move(char instruction) {
        if (direction.equals(Direction.N)) {
            if (instruction == 'f') {
                increaseY();
            } else if (instruction == 'b') {
                decreaseY();
            }
        } else if (direction.equals(Direction.E)) {
            if (instruction == 'f') {
                increaseX();
            } else if (instruction == 'b') {
                decreaseX();
            }
        } else if (direction.equals(Direction.S)) {
            if (instruction == 'f') {
                decreaseY();
            } else if (instruction == 'b') {
                increaseY();
            }
        } else if (direction.equals(Direction.W)) {
            if (instruction == 'f') {
                decreaseX();
            } else if (instruction == 'b') {
                increaseX();
            }
        }
    }

    private void decreaseX() {
        x = (x - 1 + planet.getSize()) % planet.getSize();
    }

    private void increaseX() {
        x = (x + 1) % planet.getSize();
    }

    private void decreaseY() {
        // avoid negative modules
        y = (y - 1 + planet.getSize()) % planet.getSize();
    }

    private void increaseY() {
        y = (y + 1) % planet.getSize();
    }

    private boolean isMoveInstruction(char instruction) {
        return instruction == 'f' || instruction == 'b';
    }

}
