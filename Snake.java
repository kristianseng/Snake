package com.codegym.games.snake;
import com.codegym.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public boolean isAlive = true;

    private Direction direction = Direction.LEFT;
    private static final String HEAD_SIGN  = "\uD83D\uDC7E";
    private static final String BODY_SIGN  = "\u26AB";


    private List<GameObject> snakeParts = new ArrayList<>();


    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
    }

    public void move() {
        GameObject obj = createNewHead();
        if(obj.x >= SnakeGame.WIDTH || obj.x < 0 || obj.y >= SnakeGame.WIDTH || obj.y < 0) {
            isAlive = false;
        } else {
            snakeParts.add(0, obj);
            removeTail();
        }
    }

    public GameObject createNewHead() {
        GameObject obj = snakeParts.get(0);
        switch (direction) {
            case LEFT:
                return new GameObject(obj.x - 1, obj.y);
            case RIGHT:
                return new GameObject(obj.x + 1, obj.y);
            case UP:
                return new GameObject(obj.x, obj.y - 1);
            case DOWN:
                return new GameObject(obj.x, obj.y + 1);
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size()-1);
    }

    public void draw(Game game) {
        for(GameObject obj : snakeParts) {
            if(snakeParts.get(0).equals(obj)) {
                if(isAlive) {
                    game.setCellValueEx(obj.x, obj.y, Color.NONE, HEAD_SIGN, Color.BLACK, 75);
                } else {
                    game.setCellValueEx(obj.x, obj.y, Color.NONE, HEAD_SIGN, Color.RED, 75);
                }
            } else {
                if(isAlive) {
                    game.setCellValueEx(obj.x, obj.y, Color.NONE, BODY_SIGN, Color.BLACK, 75);
                } else {
                    game.setCellValueEx(obj.x, obj.y, Color.NONE, BODY_SIGN, Color.RED, 75);
                };
            }

        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
