package com.example.demo;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Control {


    static Dir direction = Dir.RIGHT;
    public enum Dir {
        LEFT, UP, DOWN, RIGHT
    }

    static void Event(Scene scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W) {
                direction = Dir.UP;
            }
            if (key.getCode() == KeyCode.S) {
                direction = Dir.DOWN;
            }
            if (key.getCode() == KeyCode.A) {
                direction = Dir.LEFT;
            }
            if (key.getCode() == KeyCode.D) {
                direction = Dir.RIGHT;
            }

        });
    }

    static void Event_move() {
        switch (direction) {
            case UP:
                Snake.snake.get(0).y--;
                if (Snake.snake.get(0).y < 0) {
                    Main.gameOver = true;
                }
                break;
                case LEFT:
                Snake.snake.get(0).x--;
                if (Snake.snake.get(0).x < 0) {
                    Main.gameOver = true;
                }
                break;
            case DOWN:
                Snake.snake.get(0).y++;
                if (Snake.snake.get(0).y > (Board.max_y/26)) {
                    Main.gameOver = true;
                }
                break;
            case RIGHT:
                Snake.snake.get(0).x++;
                if (Snake.snake.get(0).x >(Board.max_x/26)) {
                    Main.gameOver = true;
                }
                break;

        }
    }
}
