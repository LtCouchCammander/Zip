import java.util.Stack;
import java.util.ArrayList;

public class BoardCount {
    ArrayList<PositionNumber> numbers;
    ArrayList<Position> validPath;
    Boundary boundary;
    Size size;





    public BoardCount(Boundary boundary, Size size) {
        this.size = size;
        this.boundary = boundary;
        numbers = new ArrayList<>();
        int amount = Rand.randomInt(8, 16);
        for (int i = 1; i <= amount; i++) {
            numbers.addLast(new PositionNumber(i, Rand.randomInt(0, 10), Rand.randomInt(0, 10)));
        }

        validPath = new ArrayList<>();
    }

    // LEFT position.X() < 1
    // RIGHT position.X() + size.width() > boundary.getGridWidth() - 1
    // UP position.Y() < 1
    // DOWN position.Y() + size.height() > boundary.getGridHeight() - 1


    public int findPath(int x, int y) {
        ArrayList<Position> tries = new ArrayList<>();

        while (tries.size() < 4) {
            switch (Rand.randomInt(1, 5)) {
                case 1:
                    // Try Left
                    if (!(x < 1)) {
                        return findPath(x-1, y);
                    }
                    else {
                        tries.add(new Position(x-1, y));
                    }
                    break;
                case 2:
                    // Try Right
                    if (!(x + size.width() > boundary.getGridWidth() - 1)) {
                        return findPath(x + size.width(), y);
                    }
                    else {
                        tries ++
                    }
            }
        }


        switch (Rand.randomInt(1, 5)) {
            case 1:
                if (!(x < 1)) {
                    return findPath(x-1, y);
                }
                break;

        }
    }

    public ArrayList<PositionNumber> getBoardNumbers() {
        return numbers;
    }









}
