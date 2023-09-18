package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Snake {


    static List<Corner> snake = new ArrayList<>();

    public static class Corner {
        int x;
        int y;

        public Corner(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void add() {
        snake.add(new Corner(Board.field_x , Board.field_y));
        snake.add(new Corner(Board.field_x , Board.field_y));
        snake.add(new Corner(Board.field_x , Board.field_y));
    }

     static void suicide() {
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                Main.gameOver = true;
            }
        }
    }

     static void texture(GraphicsContext gc, int cornersize) {
        for (Corner c : Snake.snake) {
            gc.setFill(Color.GREY);
            gc.fillRect(c.x * cornersize, c.y * cornersize + 15, cornersize, cornersize - 10);
            gc.setFill(Color.GREEN);
            gc.fillOval(c.x * cornersize, c.y * cornersize, cornersize, cornersize + 1);
            gc.setFill(Color.LIGHTGREY);
            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 9, cornersize);
            gc.setFill(Color.WHITE);
            gc.fillOval(c.x * cornersize, c.y * cornersize, cornersize, cornersize - 8);


        }

    }
}
