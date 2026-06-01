import java.util.LinkedList;
public class Tracking {
    private LinkedList<Position> trail;

    public Tracking() {
        trail = new LinkedList<>();
    }

    public void save(Position pos) {
        trail.addLast(new Position(pos.X(), pos.Y()));
    }

    /*
    public boolean checkLastPos(Position pos) {
        if (trail.getLast().X() == pos.X() - 1 && trail.getLast().Y() == pos.Y()) {
            trail.removeLast();
            return true;
        }
        return false;
    }
     */


    public LinkedList<Position> seeTrail() {
        return trail;
    }
}
