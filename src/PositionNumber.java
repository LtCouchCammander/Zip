public class PositionNumber extends Position{
    private int number;
    public PositionNumber(int num, int x, int y) {
        super(x, y);
        number = num;
    }

    public int getNumber() {
        return number;
    }
}

