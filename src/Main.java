public class Main {
    /*
    Inheritence: uhhhhhhh
    sorting: Players scores are put into a leaderboard. leaderboard is then sorted greatest to least

    --- CheckList ---
    Player needs to move throughout the grid. DONE
    Its previous locations are saved and cannot be touched or crossed. DONE
    Diagonal movement is not allowed. DONE
    Player must be able to back track. DONE
    There must be a timer until completion. DONE
    Player must go over certain positions labeled 1 to 10 in order from least to greatest. DONE

    1. Timed gaming sessions, will need to figure out how to implement that (might need separate process). Also, this is where I intend to implement sorting.
    2. Adding in the game logic (Numbers throughout the grid, and you have to go through each one from lowest to highest while filling in all the grids squares). - FOCUS
    3. Maybe making the game look better (Since the players previous steps is just filled red, it might look confusing mid to late game in a sea of red. May also need to make the "menu" ui better since if were going to have a timed leader board to be sorted it will need an easier way to start/stop games within the same running session.)
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
/*
issues atm:

Numbers are randomly generated but can be duplicated.
Completion of game is not guaranteed
Need a way to track if the player has successfully filled all squares and filled numbers from lowest to highest.
 */