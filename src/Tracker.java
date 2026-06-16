import java.util.ArrayList;
import java.util.LinkedList;
public class Tracker {
    private LinkedList<Position> trail;

    public Tracker() {
        trail = new LinkedList<>();
    }

    public void save(Position pos) {
        trail.addLast(new Position(pos.X(), pos.Y()));
    }

    public Position get2ndLast() {
        if (trail.size() >= 2) {
            return trail.get(trail.size() - 2);
        }
        return trail.getLast(); // Don't think it will ever use this. Just a filler.
    }

    public LinkedList<Position> seeTrail() {
        return trail;
    }

    public boolean hasWon(Boundary boundary, Board board) {
        // lul, win function has a bug in it atm. You can just fill all the squares to win.
        if (trail.size() == boundary.getGridHeight() * boundary.getGridWidth()) {

            ArrayList<Integer> listOfNumbers = new ArrayList<>();
            ArrayList<PositionNumber> boardNumbers = board.getBoardNumbers();

            int count = 0;
            for (Position i : trail) {
                PositionNumber posNum = boardNumbers.get(count);
                if (i.X() == posNum.X() && i.Y() == posNum.Y()) {
                    listOfNumbers.add(posNum.getNumber());
                    count++;
                }
            }

            for (int i = 0; i < listOfNumbers.size() - 1; i++) {
                if (listOfNumbers.get(i) == listOfNumbers.get(i + 1) -1) {
                    return true;
                }
            }
        }
        return false;
    }
}