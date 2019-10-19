package boards.utility;

public class Square {
    public int min_x;
    public int min_y;
    public int max_x;
    public int max_y;

    public Square(int x, int y) {
        int base_x = x / 3;
        int base_y = y / 3;
        min_x = base_x * 3;
        min_y = base_y * 3;
        max_x = (base_x + 1) * 3 - 1;
        max_y = (base_y + 1) * 3 - 1;
    }
}
