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
        this.command = command;
    }

    public String pendingCommands() {
        return command.substring(cursor);
    }
}
