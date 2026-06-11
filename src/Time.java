import java.util.ArrayList;

public class Time extends Thread {
    private ArrayList<Integer> scoreboard

    @Override
    public void run() {
        int elapsedTime = 0;
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
}
