package com.example.demo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    static boolean gameOver = false;

    public  void start(Stage primaryStage) {
        try {

            Food.newFood();
            VBox root = new VBox();
            Canvas c = new Canvas(Board.max_x, Board.max_y);
            GraphicsContext gc = c.getGraphicsContext2D();
            root.getChildren().add(c);


            new AnimationTimer() {
                long lastTick = 0;
                public void handle(long now) {
                    if (now - lastTick > 100000000 ) {
                        lastTick = now;
                        tick(gc);
                    }
                }
            }.start();

            Scene scene = new Scene(root, Board.max_x, Board.max_y);


            Control.Event(scene);
            Snake.add();
            primaryStage.setScene(scene);
            primaryStage.setTitle("SNAKE");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  void tick(GraphicsContext gc) {
        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("", 60));
            gc.fillText("GAME OVER", 230, 390);

            gc.setFill(Color.GREEN);
            gc.setFont(new Font("", 40));
            gc.fillText("NEW GAME?", 290, 430);

            gc.setFill(Color.DARKGREY);
            gc.setFont(new Font("", 20));
            gc.fillText("Y/N", 380, 460);
            Button button = new Button("Click Me");
            HBox h = new HBox();
            h.getChildren().addAll(button);




            return ;
        }

        for (int i = Snake.snake.size() - 1; i >= 1; i--) {
            Snake.snake.get(i).x = Snake.snake.get(i - 1).x;
            Snake.snake.get(i).y = Snake.snake.get(i - 1).y;
        }

        Control.Event_move();
        Food.eat();
        Snake.suicide();
        Board.texture(gc);
        Food.texture(gc, Board.cornersize);
        Snake.texture(gc, Board.cornersize);

    }
}