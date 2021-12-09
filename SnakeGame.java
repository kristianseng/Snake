package com.codegym.games.snake;

import com.codegym.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;


    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();



    }

    private void createGame() {
        Snake snaky = new Snake(WIDTH/2, HEIGHT/2);
        this.snake = snaky;
        drawScene();
    }
    private void drawScene() {
        for(int i = 0; i < WIDTH; i++) {
            for(int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.DARKSEAGREEN);
            }
        }
        snake.draw(this);
    }

}
