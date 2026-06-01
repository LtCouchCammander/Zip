public class Player {
    private Position position;
    private Size size;

    public Player(Position pos, Size size) {
        this.position = pos;
        this.size = size;
    }

    public void moveLeft(Tracking history) {
        if (position.X() < 1) { // If position is at boundary, it cannot move left and remains in the same position.
            position.setPosition(position.X(), position.Y());
        } else if (history.seeTrail().getLast().X() == position.X() - 1 && history.seeTrail().getLast().Y() == position.Y()) { // Checks to see if player wants to back track.
            history.seeTrail().removeLast();
            position.setPosition(position.X() - 1, position.Y());
        }
        else {
            boolean positionFilled = false;
            for (Position i : history.seeTrail()) { // Checks to see if players desired location has already been filled.
                if (i.X() == position.X() - 1 || i.Y() == position.Y()) {
                    positionFilled = true;
                    break;
                }
            }
            if (positionFilled) {
                position.setPosition(position.X() - 1, position.Y());
            }
        }
    }

    public void moveRight(Boundary boundary, Tracking history) {
        if (position.X() + size.width() > boundary.getGridWidth() - 1) { // If position is at boundary, it cannot move right and remains in the same position.
            position.setPosition(position.X(), position.Y());
        } else if (history.seeTrail().getLast().X() == position.X() + 1 && history.seeTrail().getLast().Y() == position.Y()) { // Checks to see if player wants to back track.
            history.seeTrail().removeLast();
            position.setPosition(position.X() + 1, position.Y());
        }
        else {
            boolean positionFilled = false;
            for (Position i : history.seeTrail()) { // Checks to see if players desired location has already been filled.
                if (i.X() == position.X() + 1 || i.Y() == position.Y()) {
                    positionFilled = true;
                    break;
                }
            }
            if (positionFilled) {
                position.setPosition(position.X() + 1, position.Y());
            }
        }
    }

    public void moveUp(Tracking history) {
        if (position.Y() < 1) { // If position is at boundary, it cannot move up and remains in the same position.
            position.setPosition(position.X(), position.Y());
        } else if (history.seeTrail().getLast().X() == position.X() && history.seeTrail().getLast().Y() == position.Y() - 1) {
            history.seeTrail().removeLast();
            position.setPosition(position.X(), position.Y() - 1);
        }
        else { // Player moves up...
            boolean positionFilled = false;
            for (Position i : history.seeTrail()) {
                if (i.X() == position.X() || i.Y() == position.Y() - 1) {
                    positionFilled = true;
                    break;
                }
            }
            if (positionFilled) {
                position.setPosition(position.X(), position.Y() - 1);
            }
        }
    }

    public void moveDown(Boundary boundary, Tracking history) {
        if (position.Y() + size.height() > boundary.getGridHeight() - 1) {
            position.setPosition(position.X(), position.Y());
        } else if (history.seeTrail().getLast().X() == position.X() && history.seeTrail().getLast().Y() == position.Y() + 1) {
            history.seeTrail().removeLast();
            position.setPosition(position.X(), position.Y() + 1);
        }
        else {
            boolean positionFilled = false;

            for (Position i : history.seeTrail()) {
                if (i.X() == position.X() || i.Y() == position.Y() + 1) {
                    positionFilled = true;
                    break;
                }
            }
            if (positionFilled) {
                position.setPosition(position.X(), position.Y() + 1);
            }
        }
    }

    public Position getPosition() {
        return position;
    }
    public Size getSize() {
        return size;
    }
}
