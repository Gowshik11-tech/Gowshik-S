package com.snakeandladder;

/**
 * Constants shared across the Snake and Ladder game.
 * Centralises board size and configuration so the design stays consistent.
 */
public final class GameConstants {

    private GameConstants() {
        // Utility class, prevent instantiation
    }

    public static final int BOARD_SIZE = 100;
    public static final int MIN_DICE_VALUE = 1;
    public static final int MAX_DICE_VALUE = 6;
    public static final int WINNING_POSITION = 100;
}
