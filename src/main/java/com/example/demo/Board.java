package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board {

   static final int field_x =20;
   static final int field_y =20;
   static final int box_size =40;

   static final int max_x = field_x*box_size;
   static final int max_y = field_y*box_size;
   static final int cornersize = 25;



   static void texture(GraphicsContext gc) {
      gc.setFill(Color.ANTIQUEWHITE);
      gc.fillRect(0, 0, Board.max_x, Board.max_y);//
   }
}


