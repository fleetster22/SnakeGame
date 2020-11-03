import java.util.ArrayList;

//* Controls the game logic

public class SnakeController extends Thread {
    ArrayList<ArrayList<DataOfSquare>> Squares = new ArrayList<ArrayList<DataOfSquare>>();
    XY foodPosition;
    XY headPosition;
    ArrayList<XY> positions = new ArrayList<XY>();
    int snakeSize = 3;
    long snakeSpeed = 120;
    public static int snakeDirection;
    int gridNumber = 40;
    int gridIdx = gridNumber - 1;

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
            checkCollision();

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
    private void checkCollision() {
        XY pos = positions.get(positions.size() - 1);

        boolean eatingFood = pos.getX() == foodPosition.y && pos.getY() == foodPosition.x;
        if (eatingFood) {
            snakeSize = snakeSize + 1;
            foodPosition = getPosWithoutSnake();
            positionFood(foodPosition);
        }
        if (snakeSize > 4 && snakeSize <= 10) {
            snakeSpeed = 100;
        }
        if (snakeSize > 10 && snakeSize <= 15) {
            snakeSpeed = 90;
        }
        if (snakeSize >= 15 && snakeSize < 20) {
            snakeSpeed = 80;
        }
        if (snakeSize >= 20 && snakeSize < 25) {
            snakeSpeed = 60;
        }
        if (snakeSize >= 25 && snakeSize < 30) {
            snakeSpeed = 40;
        }
    }

    // TODO what happens on stop (game over)

    // * Food position
    private void positionFood(XY foodPos) {
        Squares.get(foodPos.x).get(foodPos.y).ColorIt(1);
    }

    // TODO method to show where snake is / is not

    private XY getPosWithoutSnake() {
        XY pos;
        int randomX = 0 + (int) (Math.random() * gridIdx);
        int randomY = 0 + (int) (Math.random() * gridIdx);
        pos = new XY(randomX, randomY);
        for (int i = 0; i <= positions.size() - 1; i++) {
            if (pos.getY() == positions.get(i).getX() && pos.getX() == positions.get(i).getY()) {

                pos = new XY(randomX, randomY);
                i = 0;
            }
        }
        return pos;
    }

    // TODO ability to move snake => arrayList
    // * 1 => right, 2 => left, 3 => up, 4 => down, 0 => do nothing

    private void moveSnake(int direction) {
        switch (direction) {
            case 4: // move down
                headPosition.ChangeData(headPosition.x, Math.abs(headPosition.y + 1) % gridNumber);
                positions.add(new XY(headPosition.x, headPosition.y));
                break;
            case 3: // move up
                // headPosition.ChangeData(headPosition.x, Math.abs(headPosition.y - 1) %
                // gridNumber);
                // positions.add(new XY(headPosition.x, headPosition.y));
                // break;
                if (headPosition.y - 1 < 0) {
                    headPosition.ChangeData(headPosition.x, gridIdx);
                } else {
                    headPosition.ChangeData(headPosition.x, Math.abs(headPosition.y - 1) % gridNumber);
                    positions.add(new XY(headPosition.x, headPosition.y));
                }
                break;
            case 2: // move left
                if (headPosition.x - 1 < 0) {
                    headPosition.ChangeData(gridIdx, headPosition.y);
                } else {
                    headPosition.ChangeData(Math.abs(headPosition.x - 1) % gridNumber, headPosition.y);

                }
                positions.add(new XY(headPosition.x, headPosition.y));
                break;

            // headPosition.ChangeData(Math.abs(headPosition.x - 1) % gridNumber,
            // headPosition.y);
            // positions.add(new XY(headPosition.x, headPosition.y));
            // break;

            case 1: // move right
                headPosition.ChangeData(Math.abs(headPosition.x + 1) % gridNumber, headPosition.y);
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
            Squares.get(y).get(x).ColorIt(2);
        }
    }

    private void snakeTail() {
        int newSnakeSize = snakeSize;

        for (int i = positions.size() - 1; i >= 0; i--) {
            if (newSnakeSize == 0) {
                XY t = positions.get(i);
                Squares.get(t.y).get(t.x).ColorIt(0);
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
}
