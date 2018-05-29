package io.github.kata.mars;

public class RoverHandler {

    private int x;
    private int y;
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
}
