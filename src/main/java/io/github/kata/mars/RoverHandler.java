package io.github.kata.mars;

import lombok.Getter;

public class RoverHandler {

    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private String direction;

    private String command;
    private int cursor = 0;

    public RoverHandler(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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
            if (isRotateinstruction(instruction)) {
                rotate(instruction);
            }
            cursor++;
        }
    }

    private void rotate(char instruction) {
        final String directions = Direction.N + Direction.E + Direction.S + Direction.W;
        int currentDirectionPos = directions.indexOf(direction);
        if (instruction == 'l') {
            this.direction = String.valueOf(directions.charAt((currentDirectionPos + 1) % 4));
        } else if (instruction == 'r') {
            // add 4 to ensure positive module
            this.direction = String.valueOf(directions.charAt((currentDirectionPos - 1 + 4) % 4));
        }
    }

    private boolean isRotateinstruction(char instruction) {
        return instruction == 'l' || instruction == 'r';
    }

    private void move(char instruction) {
        if (direction.equals(Direction.N)) {
            if (instruction == 'f') {
                y++;
            } else if (instruction == 'b') {
                y--;
            }
        } else if (direction.equals(Direction.E)) {
            if (instruction == 'f') {
                x++;
            } else if (instruction == 'b') {
                x--;
            }
        } else if (direction.equals(Direction.S)) {
            if (instruction == 'f') {
                y--;
            } else if (instruction == 'b') {
                y++;
            }
        } else if (direction.equals(Direction.W)) {
            if (instruction == 'f') {
                x--;
            } else if (instruction == 'b') {
                x++;
            }
        }
    }

    private boolean isMoveInstruction(char instruction) {
        return instruction == 'f' || instruction == 'b';
    }


}
