package com.snakeandladder;

import java.util.ArrayList;
import java.util.List;

/**
 * Core game engine that simulates dice rolls and movement on a 100-cell board.
 *
 * LLD focus:
 *   - ARRAY:   players stored in a List/array; positions tracked per player.
 *   - RANDOM:  dice rolls via the Dice class.
 *   - HASHMAP: jump (snake/ladder) lookup via Board.
 */
public class Game {

    private final Board board;
    private final Dice dice;
    private final List<Player> players;

    public Game() {
        this.board = new Board();
        this.dice = new Dice();
        this.players = new ArrayList<>();
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void play() {
        if (players.isEmpty()) {
            System.out.println("No players added. Add players before starting.");
            return;
        }

        System.out.println("=== Snake and Ladder Game Started ===");
        System.out.println("Board size: " + GameConstants.BOARD_SIZE + " cells");
        System.out.println("Jumps configured: " + board.getJumps().size());
        System.out.println();

        int turn = 0;
        while (true) {
            Player current = players.get(turn % players.size());
            int roll = dice.roll();

            System.out.println(current.getName() + " rolled a " + roll);

            int next = current.getPosition() + roll;

            // Prevent overshooting the winning cell
            if (next > GameConstants.WINNING_POSITION) {
                System.out.println("  -> Overshoot! Stays at " + current.getPosition());
            } else {
                current.setPosition(next);
                System.out.println("  -> Moved to " + current.getPosition());

                // HashMap lookup for snake/ladder
                if (board.hasJump(current.getPosition())) {
                    int destination = board.getJumpDestination(current.getPosition());
                    if (board.isLadder(current.getPosition())) {
                        System.out.println("  -> LADDER! Climbed from "
                                + current.getPosition() + " to " + destination);
                    } else {
                        System.out.println("  -> SNAKE! Slid from "
                                + current.getPosition() + " to " + destination);
                    }
                    current.setPosition(destination);
                }
            }

            if (current.getPosition() == GameConstants.WINNING_POSITION) {
                System.out.println();
                System.out.println("************************************");
                System.out.println("  " + current.getName() + " WINS!");
                System.out.println("************************************");
                break;
            }

            System.out.println();
            turn++;
        }
    }
}
