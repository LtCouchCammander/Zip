import java.util.Stack;
import java.util.ArrayList;

public class BoardCount {
    ArrayList<PositionNumber> numbers;
    ArrayList<Position> validPath;





    public BoardCount() {
        numbers = new ArrayList<>();
        int amount = Rand.randomInt(8, 16);
        for (int i = 1; i <= amount; i++) {
            numbers.addLast(new PositionNumber(i, Rand.randomInt(0, 10), Rand.randomInt(0, 10)));
        }

        validPath = new ArrayList<>();
    }

    public ArrayList<PositionNumber> getBoardNumbers() {
        return numbers;
    }









}
