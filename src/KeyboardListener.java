import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
    // Keycodes 38-up, 39-right, 40-down, 37-left
    // 1 => right, 2 => left, 3 => up, 4 => down, 0 => do nothing

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 39:
                if (SnakeController.snakeDirection != 2) {
                    SnakeController.snakeDirection = 1;
                }
                break;
            case 38:
                if (SnakeController.snakeDirection != 4) {
                    SnakeController.snakeDirection = 3;
                }
                break;
            case 37:
                if (SnakeController.snakeDirection != 1) {
                    SnakeController.snakeDirection = 2;
                }
                break;
            case 40:
                if (SnakeController.snakeDirection != 3) {
                    SnakeController.snakeDirection = 4;
                }
                break;
            default:
                break;
        }
    }
}
