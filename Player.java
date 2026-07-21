package com.snakeandladder;

/**
 * Represents a player on the board.
 *
 * LLD focus - ARRAY:
 *   Player positions in the game are tracked via an int[] array in the
 *   Game class (one slot per player); each Player simply knows its name.
 */
public class Player {

    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 1; // all players start at cell 1
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void moveBy(int steps) {
        this.position += steps;
    }
}
