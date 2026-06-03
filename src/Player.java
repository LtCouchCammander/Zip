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
        } else if (history.get2ndLast().X() == position.X() - 1 && history.get2ndLast().Y() == position.Y()) { // Checks to see if player wants to back track.
            history.seeTrail().removeLast();
            position.setPosition(position.X() - 1, position.Y());
        }
        else { // Checks to see if players desired location has already been filled. Otherwise, moves left.
            boolean positionFilled = false;
            for (Position i : history.seeTrail()) {
                if (i.X() == position.X() - 1 && i.Y() == position.Y()) {
                    positionFilled = true;
                    break;
                }
            }
            if (!positionFilled) {
                position.setPosition(position.X() - 1, position.Y());
                history.save(position);
            }
        }
    }

    public void moveRight(Boundary boundary, Tracking history) {
        if (position.X() + size.width() > boundary.getGridWidth() - 1) { // If position is at boundary, it cannot move right and remains in the same position.
            position.setPosition(position.X(), position.Y());
        } else if (history.get2ndLast().X() == position.X() + 1 && history.get2ndLast().Y() == position.Y()) { // Checks to see if player wants to back track.
            history.seeTrail().removeLast();
            position.setPosition(position.X() + 1, position.Y());
        }
        else { // Checks to see if players desired location has already been filled. Otherwise, moves right.
            boolean positionFilled = false;
            for (Position i : history.seeTrail()) {
                if (i.X() == position.X() + 1 && i.Y() == position.Y()) {
                    positionFilled = true;
                    break;
                }
            }
            if (!positionFilled) {
                position.setPosition(position.X() + 1, position.Y());
                history.save(position);
            }
        }
    }

    public void moveUp(Tracking history) {
        if (position.Y() < 1) { // If position is at boundary, it cannot move up and remains in the same position.
            position.setPosition(position.X(), position.Y());
        } else if (history.get2ndLast().X() == position.X() && history.get2ndLast().Y() == position.Y() - 1) { // Checks to see if player wants to back track.
            history.seeTrail().removeLast();
            position.setPosition(position.X(), position.Y() - 1);
        }
        else { // Checks to see if players desired location has already been filled. Otherwise, moves up.
            boolean positionFilled = false;
            for (Position i : history.seeTrail()) {
                if (i.X() == position.X() && i.Y() == position.Y() - 1) {
                    positionFilled = true;
                    break;
                }
            }
            if (!positionFilled) {
                position.setPosition(position.X(), position.Y() - 1);
                history.save(position);
            }
        }
    }

    public void moveDown(Boundary boundary, Tracking history) {
        if (position.Y() + size.height() > boundary.getGridHeight() - 1) { // If position is at boundary, it cannot move up and remains in the same position.
            position.setPosition(position.X(), position.Y());
        } else if (history.get2ndLast().X() == position.X() && history.get2ndLast().Y() == position.Y() + 1) { // Checks to see if player wants to back track.
            history.seeTrail().removeLast();
            position.setPosition(position.X(), position.Y() + 1);
        }
        else { // Checks to see if players desired location has already been filled. Otherwise, moves up.
            boolean positionFilled = false;
            for (Position i : history.seeTrail()) {
                if (i.X() == position.X() && i.Y() == position.Y() + 1) {
                    positionFilled = true;
                    break;
                }
            }
            if (!positionFilled) {
                position.setPosition(position.X(), position.Y() + 1);
                history.save(position);
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
