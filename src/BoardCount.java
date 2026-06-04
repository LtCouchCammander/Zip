import java.util.ArrayList;

public class BoardCount {
    ArrayList<PositionNumber> Numbers;

    public BoardCount() {
        Numbers = new ArrayList<>();
        int amount = Rand.randomInt(8, 16);
        for (int i = 1; i <= amount; i++) {
            Numbers.addLast(new PositionNumber(Rand.randomInt(10, 10), Rand.randomInt(10, 10), i));
        }
    }


}
