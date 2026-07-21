package com.snakeandladder;

import java.util.Random;

/**
 * Dice abstraction.
 *
 * LLD focus - RANDOM:
 *   Uses java.util.Random to simulate fair dice rolls between
 *   MIN_DICE_VALUE and MAX_DICE_VALUE (1-6).
 */
public class Dice {

    private final Random random;
    private final int minValue;
    private final int maxValue;

    public Dice() {
        this.random = new Random();
        this.minValue = GameConstants.MIN_DICE_VALUE;
        this.maxValue = GameConstants.MAX_DICE_VALUE;
    }

    /**
     * Rolls the dice and returns a value in [minValue, maxValue].
     */
    public int roll() {
        // random.nextInt(bound) -> [0, bound); add 1 for [1, 6]
        return minValue + random.nextInt(maxValue - minValue + 1);
    }
}
