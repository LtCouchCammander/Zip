public class Main {
    /*
    Inheritence: uhhhhhhh
    sorting: Players scores are put into a leaderboard. leaderboard is then sorted greatest to least

    --- CheckList ---
    Player needs to move throughout the grid. DONE
    Its previous locations are saved and cannot be touched or crossed. DONE
    Diagonal movement is not allowed. DONE
    Player must be able to back track. DONE
    There must be a timer until completion.
    Player must go over certain positions labeled 1 to 10 in order from least to greatest.


     */
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}