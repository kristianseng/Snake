package com.codegym.games.snake;
import com.codegym.engine.cell.*;

public class SnakeGame extends Game {
    public static final int HEIGHT = 15;
    public static final int WIDTH = 15;
    private Snake snake;
    private int turnDelay;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int sec) {
        snake.move();
        drawScene();
    }
    private void createGame() {
        turnDelay = 300;
        setTurnTimer(turnDelay);
        Snake snake = new Snake(WIDTH/2, HEIGHT/2);
        this.snake = snake;
        drawScene();

    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x,y,Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
    }
}
