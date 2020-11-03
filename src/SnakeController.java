import java.util.ArrayList;

//* Controls the game logic

public class SnakeController extends Thread {
    ArrayList<ArrayList<DataOfSquare>> Squares = new ArrayList<ArrayList<DataOfSquare>>();
    XY foodPosition;
    XY headPosition;
    ArrayList<XY> positions = new ArrayList<XY>();
    int snakeSize = 3;
    long snakeSpeed = 30;
    public static int snakeDirection;

    SnakeController(XY pos) {
        Squares = Window.Grid;

        headPosition = new XY(pos.x, pos.y);
        snakeDirection = 1;

        XY newHeadPosition = new XY(headPosition.getX(), headPosition.getY());
        positions.add(newHeadPosition);

        foodPosition = new XY(Window.height - 1, Window.width - 1);
        positionFood(foodPosition);
    }

    // TODO get threads

    public void run() {
        while (true) {
            moveSnake(snakeDirection);
            moveSnakeColor();
            snakeTail();
            pauseSnake();
        }
    }

    private void pauseSnake() {
        try {
            sleep(snakeSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // TODO check if snake eats food

    // TODO check if snake runs into self

    // TODO what happens on stop (game over)

    // TODO position the food (new food)
    private void positionFood(XY foodPos) {
        Squares.get(foodPos.x).get(foodPos.y).ColorIt(1);
    }

    // TODO method to show where snake is / is not so we can position food where
    // snake is not

    // TODO ability to move snake => arrayList
    // * 1 => right, 2 => left, 3 => up, 4 => down, 0 => do nothing

    private void moveSnake(int direction) {
        switch (direction) {
            case 4: // move down
                headPosition.ChangeData(headPosition.x, Math.abs(headPosition.y + 1) % 20);
                positions.add(new XY(headPosition.x, headPosition.y));
                break;
            case 3: // move up
                if (headPosition.y - 1 < 0) {
                    headPosition.ChangeData(headPosition.x, 19);
                } else {
                    headPosition.ChangeData(headPosition.x, Math.abs(headPosition.y - 1) % 20);

                }
                break;
            case 2: // move left
                if (headPosition.x - 1 < 0) {
                    headPosition.ChangeData(19, headPosition.y);
                } else {
                    headPosition.ChangeData(Math.abs(headPosition.x - 1) % 20, headPosition.y);

                }
                break;
            case 1: // move right
                headPosition.ChangeData(Math.abs(headPosition.x + 1) % 20, headPosition.y);
                positions.add(new XY(headPosition.x, headPosition.y));
                break;
            default:
                break;
        }
    }

    private void moveSnakeColor() {
        for (XY i : positions) {
            int y = i.getY();
            int x = i.getX();
            Squares.get(y).get(x).ColorIt(0);
        }
    }

    private void snakeTail() {
        int newSnakeSize = snakeSize;

        for (int i = positions.size() - 1; i >= 0; i--) {
            if (newSnakeSize == 0) {
                XY t = positions.get(i);
                Squares.get(t.y).get(t.x).ColorIt(2);
            } else {
                newSnakeSize--;
            }
        }
        newSnakeSize = snakeSize;
        for (int i = positions.size() - 1; i >= 0; i--) {
            if (newSnakeSize == 0) {
                positions.remove(i);
            } else {
                newSnakeSize--;
            }
        }

    }

    // TODO refresh the squares (repaint) when snake moves => tail and head of snake

}
