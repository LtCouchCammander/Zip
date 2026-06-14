import java.util.Collections;
import java.util.ArrayList;

public class Board {
    private ArrayList<PositionNumber> numbers;
    private Boundary boundary;
    private Size size;
    private ArrayList<Position> validPath;
    private boolean[][] visited;

    public Board(Boundary boundary, Size size) {
        this.size = size;
        this.boundary = boundary;

        validPath = new ArrayList<>();
        visited = new boolean[boundary.getGridWidth()][boundary.getGridHeight()];

        numbers = new ArrayList<>();
    }

    public boolean generatePath(int x, int y) {

        // Marking the current position within the 2d boolean array to true and then adding it onto the path.
        if (!(visited[x][y])) {
            visited[x][y] = true;
            validPath.add(new Position(x, y));
        }

        for (Position i : validPath) {
            System.out.print("[" + i.X() + ", " + i.Y() + "]");
        }
        System.out.println();

        // Checks to see if the path is already complete (base case)
        if (validPath.size() == boundary.getGridWidth() * boundary.getGridHeight()) {
            return true;
        }

        ArrayList<Position> neighbors = getNeighbors(x, y);
        Collections.shuffle(neighbors);

        for (Position i : neighbors) {
            if (!(visited[i.X()][i.Y()])) {
                if (generatePath(i.X(), i.Y())) {
                    return true;
                }
            }
        }
        validPath.removeLast();
        visited[x][y] = false;
        return false;
    }

    public ArrayList<Position> getNeighbors(int x, int y) {
        ArrayList<Position> neighborsList = new ArrayList<>();

        // Checks left boundary
        if (x > 0) {
            neighborsList.add(new Position(x - 1, y));
        }
        // Checks right boundary
        if (x < boundary.getGridWidth() - 1) {
            neighborsList.add(new Position(x + 1, y));
        }
        // Checks boundary above
        if (y > 0) {
            neighborsList.add(new Position(x, y - 1));
        }
        // Checks boundary below
        if (y < boundary.getGridHeight() - 1) {
            neighborsList.add(new Position(x, y + 1));
        }
        return neighborsList;
    }

    public void fillBoard() {
        int currentNumber = 1;
        int currentCount = 0;
        for (Position i : validPath) {
            if (currentCount == boundary.getGridHeight() - 1) {
                numbers.add(new PositionNumber(currentNumber, i.X(), i.Y()));
                currentNumber++;
                currentCount = -1;
            }
            currentCount++;
        }
        System.out.println();
        System.out.println();
        for (PositionNumber i : numbers) {
            System.out.print(i.getNumber() + "[" + i.X() + ", " + i.Y() + "]");
        }
    }

    public ArrayList<PositionNumber> getBoardNumbers() {
        return numbers;
    }









}

