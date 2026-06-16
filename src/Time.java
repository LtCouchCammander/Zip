import java.util.ArrayList;

public class Time extends Thread {
    private int elapsedTime = 0;
    private ArrayList<Integer> scoreboard = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                elapsedTime++;
                System.out.println("Elapsed Time: " + elapsedTime + "s");
            } catch (InterruptedException e) { // Intellij recommended an exception catch.
                throw new RuntimeException(e);
            }
        }
    }

    public void recordTime() {
        scoreboard.add(elapsedTime);
    }

    public void resetTime() {
        elapsedTime = 0;
    }

    public void printSortedScoreboard() {
        scoreboard.sort(null);
        System.out.println("SCOREBOARD RANKED BEST TO WORST TIMES: ");
        for (int i : scoreboard) {
            System.out.println("1. " + i + "s");
        }
    }
}