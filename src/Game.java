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
    private Tracker history;
    private Board board;
    private Time time = new Time();

    public Game() {
        // Moved constructor into dedicated game setup method since after a game finished I wanted to be able to re-run what was current in the constructor
    }

    public void run() {
        // Starts the timer for the game.
        time.start();

        // =========================================
        // LOOP TO UPDATE GAME STATE EACH FRAME
        // =========================================

        while (true) {
            // Sets up game
            setUpGame();

            boolean status = true;
            while (status) {
                // =========================================
                // PART 0: CHECK IF GAME IS WON
                // =========================================
                if (history.hasWon(boundary, board)) {
                    time.recordTime();
                    status = false;
                    canvas.closeWindow();
                    continue;
                }



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
    }

    // Originally tried stacks (wouldn't really work well since the program redraws all the time, and you can only read off the top).
    // Thought about using array lists to store positions but thought that would take too much work.
    // Going to use linked lists instead with copying the position object... or at least its actual data/positions.

    public void setUpGame() {
        player = new Player(new Position(0, 0), new Size(1, 1));
        history = new Tracker();
        // Places the default player position into tracking
        history.save(player.getPosition());
        // number of rows and columns
        boundary = new Boundary(6, 6);
        // Create drawing canvas
        canvas = new GridCanvas(boundary, 50, "ZIP!");
        canvas.showInWindow();
        // Loading in puzzle
        board = new Board(boundary, player.getSize());
        board.generatePath(0, 0);
        board.fillBoard();
    }

    private void updateGameState() {
        // get input
        inputState = canvas.getInputState();

        // respond to input for player
        // Use of if, else-if prevents diagonal movement.
        if (inputState.isLeftPressed()) {
            player.moveLeft(history);
        } else if (inputState.isRightPressed()) {
            player.moveRight(boundary, history);
        } else if (inputState.isUpPressed()) {
            player.moveUp(history);
        } else if (inputState.isDownPressed()) {
            player.moveDown(boundary, history);
        }
    }

    private void redrawVisuals() {
        canvas.clear();

        for (PositionNumber posNumb : board.getBoardNumbers()) {
            canvas.drawNumber(posNumb);
        }

        // Draws previous players moves.
        for (Position prevPosition : history.seeTrail()) {
            canvas.drawRectangle(prevPosition, player.getSize(), Color.GREEN, GridCanvas.DrawStyle.FILLED);
        }

        // Draws current player
        canvas.drawRectangle(player.getPosition(), player.getSize(), Color.BLUE, GridCanvas.DrawStyle.FILLED);

        canvas.redraw();
    }
}