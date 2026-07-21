package com.snakeandladder;

/**
 * Entry point of the Snake and Ladder LLD project.
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer("Alice");
        game.addPlayer("Bob");
        game.addPlayer("Charlie");
        game.play();
    }
}
