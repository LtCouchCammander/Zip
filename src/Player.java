public class Player {
    private Position position;
    private Size size;

    public Player(Position pos, Size size) {
        this.position = pos;
        this.size = size;
    }

    public void moveLeft() {
        if (position.X() < 1) { // If position is at boundary, it cannot move left and remains in the same position.
            position.setPosition(position.X(), position.Y());
        }
        else { // Player moves left...
            position.setPosition(position.X() - 1, position.Y());
        }
    }

    public void moveRight(Boundary boundary) {
        if (position.X() + size.width() > boundary.getGridWidth() - 1) { // If position is at boundary, it cannot move right and remains in the same position.
            position.setPosition(position.X(), position.Y());
        }
        else { // Player moves right...
            position.setPosition(position.X() + 1, position.Y());
        }
    }

    public void moveUp() {
        if (position.Y() < 1) { // If position is at boundary, it cannot move up and remains in the same position.
            position.setPosition(position.X(), position.Y());
        }
        else { // Player moves up...
            position.setPosition(position.X(), position.Y() - 1);
        }
    }

    public void moveDown(Boundary boundary) {
        if (position.Y() + size.height() > boundary.getGridHeight() - 1) {
            position.setPosition(position.X(), position.Y());
        }
        else {
            position.setPosition(position.X(), position.Y() + 1);
        }
    }

    public Position getPosition() {
        return position;
    }
    public Size getSize() {
        return size;
    }
}
