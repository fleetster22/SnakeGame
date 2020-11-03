import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Anaka's Awesome Snake Game");

        Window window = new Window();

        window.setTitle("Anaka's Snake Game");
        window.setSize(600, 600);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
