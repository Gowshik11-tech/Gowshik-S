# Snake and Ladder - Java LLD Project

## Project Title
**Snake and Ladder**

## Description
Simulate dice rolls and movement on a 100-cell board where snakes and ladders
(jumps) are stored in a `HashMap`. The simulation models multiple players taking
turns, rolling a die, moving along the board, and triggering jumps until a
player reaches cell 100.

## Core Java Topics Used (LLD Focus)
- **Array**  : `int[] positions` in `Board` for O(1) cell access; player
  positions tracked per player slot.
- **Random** : `java.util.Random` in `Dice` to simulate fair 1-6 rolls.
- **HashMap** : `Map<Integer,Integer>` in `Board` storing jumps
  (key = source cell, value = destination cell).

## Package Structure
```
com.snakeandladder
├── GameConstants.java  (board size, dice range, winning cell)
├── Board.java          (Array + HashMap of jumps)
├── Dice.java           (Random dice roll)
├── Player.java         (player name + position)
├── Game.java           (engine: turn loop, movement, jump resolution)
└── Main.java           (entry point)
```

## How to Run (VS Code)
1. Open the `snake and ladder` folder in Visual Studio Code.
2. Install the **Extension Pack for Java** when prompted.
3. Open `src/com/snakeandladder/Main.java`.
4. Press `F5` (or Run → Start Debugging) to launch.

## Sample Output
```
=== Snake and Ladder Game Started ===
Board size: 100 cells
Jumps configured: 15

Alice rolled a 4
  -> Moved to 5

Bob rolled a 6
  -> Moved to 7
...
Alice rolled a 3
  -> Moved to 2
  -> LADDER! Climbed from 2 to 23
...
Charlie WINS!
```
