package com.snakeandladder;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the 100-cell board.
 *
 * LLD focus - HASHMAP:
 *   The jumps (snakes and ladders) are stored in a HashMap<Integer, Integer>
 *   where the key is the start cell and the value is the destination cell.
 *   - Ladder:  key < value  (moves player forward / up)
 *   - Snake:   key > value  (moves player backward / down)
 *
 * LLD focus - ARRAY:
 *   The board is also modelled conceptually as a fixed 100-cell grid
 *   (positions[]) to make cell lookup O(1) and to show array usage.
 */
public class Board {

    // Array: 1-indexed logical board cells (index 0 unused for readability)
    private final int[] positions;

    // HashMap: cell -> jump destination (snake head/tail or ladder bottom/top)
    private final Map<Integer, Integer> jumps;

    public Board() {
        this.positions = new int[GameConstants.BOARD_SIZE + 1];
        this.jumps = new HashMap<>();
        initialisePositions();
        initialiseJumps();
    }

    private void initialisePositions() {
        for (int cell = 1; cell <= GameConstants.BOARD_SIZE; cell++) {
            positions[cell] = cell; // identity mapping, cell value = cell index
        }
    }

    private void initialiseJumps() {
        // Ladders: start (lower) -> end (higher)
        jumps.put(2, 23);
        jumps.put(8, 34);
        jumps.put(20, 77);
        jumps.put(32, 68);
        jumps.put(41, 79);
        jumps.put(54, 88);
        jumps.put(71, 91);

        // Snakes: start (higher) -> end (lower)
        jumps.put(17, 4);
        jumps.put(30, 12);
        jumps.put(43, 25);
        jumps.put(50, 10);
        jumps.put(62, 19);
        jumps.put(86, 24);
        jumps.put(95, 56);
        jumps.put(98, 40);
    }

    /**
     * Returns the destination cell if a jump (snake/ladder) exists at the
     * given cell, otherwise returns the same cell.
     */
    public int getJumpDestination(int cell) {
        return jumps.getOrDefault(cell, cell);
    }

    public boolean hasJump(int cell) {
        return jumps.containsKey(cell);
    }

    public boolean isLadder(int cell) {
        return jumps.containsKey(cell) && jumps.get(cell) > cell;
    }

    public boolean isSnake(int cell) {
        return jumps.containsKey(cell) && jumps.get(cell) < cell;
    }

    public int[] getPositions() {
        return positions;
    }

    public Map<Integer, Integer> getJumps() {
        return jumps;
    }
}
