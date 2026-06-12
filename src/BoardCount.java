import java.util.Collections;
import java.util.ArrayList;

public class BoardCount {
    ArrayList<PositionNumber> numbers;
    Boundary boundary;
    Size size;

    public ArrayList<Position> validPath;
    private boolean[][] visited;





    public BoardCount(Boundary boundary, Size size) {
        this.size = size;
        this.boundary = boundary;
        numbers = new ArrayList<>();
        int amount = Rand.randomInt(8, 16);
        for (int i = 1; i <= amount; i++) {
            numbers.addLast(new PositionNumber(i, Rand.randomInt(0, 10), Rand.randomInt(0, 10)));
        }

        validPath = new ArrayList<>();
        visited = new boolean[boundary.getGridHeight()][boundary.getGridWidth()];
    }

    public boolean generatePath(int x, int y) {
        // Checks to see if the path is already complete
        if (validPath.size() == boundary.getGridWidth() * boundary.getGridHeight()) {
            return true;
        }

        // Marking the current position within the 2d boolean array to true and then adding it onto the path.
        visited[x][y] = true;
        validPath.add(new Position(x, y));

        ArrayList<Position> neighbors = getNeighbors(x, y);
        Collections.shuffle(neighbors);

        for (Position i : neighbors) {
            if (!(visited[i.X()][i.Y()])) {
                if (generatePath(i.X(), i.Y())) {
                    return true;
                }
            }
        }
        visited[x][y] = false;
        validPath.removeLast();

        return false;

    }

    public ArrayList<Position> getNeighbors(int x, int y) {
        ArrayList<Position> neighborsList = new ArrayList<>();

        // Check left position
        if (!(x < 1)) {
            neighborsList.add(new Position(x - 1, y));
        }
        // Checks right position
        if (!(x + size.width() > boundary.getGridWidth() - 1)) {
            neighborsList.add(new Position(x + size.width(), y));
        }
        // Checks position above
        if (!(y < 1)) {
            neighborsList.add(new Position(x, y - 1));
        }
        // Checks position below
        if (!(y + size.height() > boundary.getGridHeight())){
            neighborsList.add(new Position(x, y + size.height()));
        }
        return neighborsList;
    }


    // LEFT position.X() < 1
    // RIGHT position.X() + size.width() > boundary.getGridWidth() - 1
    // UP position.Y() < 1
    // DOWN position.Y() + size.height() > boundary.getGridHeight() - 1

/*
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
                        //tries ++
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

 */

    public ArrayList<PositionNumber> getBoardNumbers() {
        return numbers;
    }









}
