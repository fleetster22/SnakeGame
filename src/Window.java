import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.GridLayout;
import java.util.ArrayList;

public class Window extends JFrame {
    public static ArrayList<ArrayList<DataOfSquare>> Grid;
    int gridNumber = 40;
    public static int width = 40;
    public static int height = 40;

    public Window() {

        // Creates threads and thread data
        Grid = new ArrayList<ArrayList<DataOfSquare>>();
        ArrayList<DataOfSquare> data;

        for (int w = 0; w < width; w++) {
            data = new ArrayList<DataOfSquare>();
            for (int h = 0; h < height; h++) {
                DataOfSquare newData = new DataOfSquare(0);
                data.add(newData);
            }
            Grid.add(data);
        }

        // Sets layout of the window panel
        getContentPane().setLayout(new GridLayout(gridNumber, gridNumber, 0, 0));

        // TODO Start and pause threads
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                getContentPane().add(Grid.get(w).get(h).square);
            }

        }

        // TODO Position the snake

        XY position = new XY(gridNumber / 2, gridNumber / 2);
        SnakeController c = new SnakeController(position);
        c.start();

        // TODO Link window to keyboard commands - Up, Down, Right, Left
        this.addKeyListener((KeyListener) new KeyboardListener());
    }
}
