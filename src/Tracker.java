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
}
