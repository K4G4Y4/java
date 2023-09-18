package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Food {


public static int X=0;
public static int Y=0;

    public static void newFood() {
        start: while (true) {
        Random rand = new Random();
            X = rand.nextInt(Board.field_x);
            Y = rand.nextInt(Board.field_y);



            for (Snake.Corner c : Snake.snake) {
                if (c.x == X && c.y == Y) {
                    continue start;
                }
            }

            break;

        }
    }



    public static void eat() {

        if (X == Snake.snake.get(0).x && Y == Snake.snake.get(0).y) {
            Snake.snake.add(new Snake.Corner(-1, -1));
            newFood();
        }
    }





     static void texture(GraphicsContext gc, int cornersize) {
        gc.setFill(Color.GREY);
        gc.fillOval(Food.X * cornersize, Food.Y * cornersize +15, cornersize, cornersize -10);
        gc.setFill(Color.RED);
        gc.fillOval(Food.X * cornersize, Food.Y * cornersize, cornersize, cornersize);
        gc.setFill(Color.DARKGREEN);
        gc.fillOval(Food.X * cornersize, Food.Y * cornersize, cornersize -9, cornersize -20);
    }




}




