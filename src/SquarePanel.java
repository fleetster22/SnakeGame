import javax.swing.JPanel;
import java.awt.Color;

public class SquarePanel extends JPanel {

    public SquarePanel(Color color) {
        this.setBackground(color);
    }

    public void ChangeColor(Color color) {
        this.setBackground(color);
        this.repaint();
    }
}
