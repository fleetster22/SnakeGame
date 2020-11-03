import java.util.ArrayList;
import java.awt.Color;

public class DataOfSquare {
    ArrayList<Color> ColorList = new ArrayList<Color>();
    int color; // 0 = blank(white), 1 = food(blue), 2 = snake(red)
    SquarePanel square;

    public DataOfSquare(int c) {
        // This adds color to the ArrayList items
        ColorList.add(Color.white); // blank = 0
        ColorList.add(Color.blue); // food = 1
        ColorList.add(Color.red); // snake = 2
        color = c;
        square = new SquarePanel(ColorList.get(color));
    }

    public void ColorIt(int c) {
        square.ChangeColor(ColorList.get(c));
    }

}
