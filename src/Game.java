import java.awt.*;

import java.util.ArrayList;

public class Game {

    // The graphical user interface (GUI) for the game
    private GridCanvas canvas;
    // Tracks which keys are currently pressed. Updated in the main loop.
    private InputState inputState;
    // Grid Boundary (i assume)
    private Boundary boundary;

    private Player player;
    private ArrayList<Position> coinPositions;

    private Tracking history;

    public Game() {
        // =========================================
        // EXAMPLE GAME/SIMULATION STATE
        // =========================================

        player = new Player(new Position(0, 0), new Size(1, 1));

        history = new Tracking();
        // Places the default player position into tracking
        history.save(player.getPosition());

        // number of rows and columns
        boundary = new Boundary(10, 10);

        // Create drawing canvas
        canvas = new GridCanvas(boundary, 50, "ZIP!");
        canvas.showInWindow();
    }

    public void run() {

        // =========================================
        // LOOP TO UPDATE GAME STATE EACH FRAME
        // =========================================

        while (true) {
            // =========================================
            // PART 0: SAVE GAME STATE
            // =========================================
            //saveGameState();

            // =========================================
            // PART 1: UPDATE GAME STATE (LOGIC ONLY)
            // =========================================
            updateGameState();


            // -------------------------------------
            // PART 2: REDRAW SCREEN (VISUALS ONLY)
            // -------------------------------------
            redrawVisuals();


            // -------------------------------------
            // PART 3: PAUSE MOMENTARILY EVERY LOOP
            // -------------------------------------
            try {
                Thread.sleep(100);
                } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    // Originally tried stacks (wouldn't really work well since the program redraws all the time, and you can only read off the top).
    // Thought about using array lists to store positions but thought that would take too much work.
    // Going to use linked lists instead with copying the position object... or at least its actual data/positions.

    private void updateGameState() {
        // get input
        inputState = canvas.getInputState();

        // respond to input for player
        /*
        if (inputState.isLeftPressed()) {
            player.moveLeft();
        }
        if (inputState.isRightPressed()) {
            player.moveRight(boundary);
        }
        if (inputState.isUpPressed()) {
            player.moveUp();
        }
        if (inputState.isDownPressed()) {
            player.moveDown(boundary);
        }

         */
        // Use of if else if prevents diagonal movement.
        if (inputState.isLeftPressed()) {
            player.moveLeft(history);
        } else if (inputState.isRightPressed()) {
            player.moveRight(boundary, history);
        } else if (inputState.isUpPressed()) {
            player.moveUp(history);
        } else if (inputState.isDownPressed()) {
            player.moveDown(boundary, history);
        }
        // Saves new position after the move.


        // logic to move enemy automatically
        //enemy.moveLeft(boundary);
        // Example of creating an ArrayList of coins
        /*
        coinPositions = new ArrayList<Position>();
        coinPositions.add(new Position(1, 1));
        coinPositions.add(new Position(8, 5));
        coinPositions.add(new Position(11, 5));
        coinPositions.add(new Position(14, 5));

         */
    }

    private void redrawVisuals() {
        canvas.clear();

        // Draws previous players moves.
        for (Position prevPosition : history.seeTrail()) {
            canvas.drawRectangle(prevPosition, player.getSize(), Color.RED, GridCanvas.DrawStyle.FILLED);
        }

        // Draws current player
        canvas.drawRectangle(player.getPosition(), player.getSize(), Color.ORANGE, GridCanvas.DrawStyle.FILLED);

        // Enemy
        //canvas.drawOval(enemy.getPosition(), enemy.getSize(), Color.BLUE, GridCanvas.DrawStyle.OUTLINED);

        // Drawing Coins from an ArrayList
        //canvas.drawOvals(coinPositions, new Size(1, 1), Color.YELLOW, GridCanvas.DrawStyle.FILLED);

        // Line example
        //canvas.drawLine(new Position(0, 0), new Position(8, 5), Color.BLACK);

        canvas.redraw();
    }
}
