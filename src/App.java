import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Anaka's Awesome Snake Game");

        Window window = new Window();
        // TODO Set window settings- exit on close
        window.setTitle("Anaka's Snake Game");
        window.setSize(500, 500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
