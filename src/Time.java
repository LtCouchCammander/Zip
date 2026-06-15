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
                System.out.println(elapsedTime);
            } catch (InterruptedException e) { // Intellij recommended an exception catch.
                throw new RuntimeException(e);
            }
        }
    }

    public void recordTime() {
        scoreboard.add(elapsedTime);
        elapsedTime = 0;
    }
}

