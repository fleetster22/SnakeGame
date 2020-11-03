import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.GridLayout;
import java.util.ArrayList;

public class Window extends JFrame {
    public static ArrayList<ArrayList<DataOfSquare>> Grid;
    public static int width = 20;
    public static int height = 20;

    public Window() {

        // Creates threads and thread data
        Grid = new ArrayList<ArrayList<DataOfSquare>>();
        ArrayList<DataOfSquare> data;

        for (int w = 0; w < width; w++) {
            data = new ArrayList<DataOfSquare>();
            for (int h = 0; h < height; h++) {
                DataOfSquare newData = new DataOfSquare(2);
                data.add(newData);
            }
            Grid.add(data);
        }

        // Sets layout of the window panel
        getContentPane().setLayout(new GridLayout(20, 20, 0, 0));

        // TODO Start and pause threads
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                getContentPane().add(Grid.get(w).get(h).square);
            }

        }

        // TODO Position the snake

        XY position = new XY(10, 10);
        SnakeController c = new SnakeController(position);
        c.start();

        // TODO Link window to keyboard commands - Up, Down, Right, Left
        this.addKeyListener((KeyListener) new KeyboardListener());
    }
}
