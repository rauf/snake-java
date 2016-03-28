package com.rauf.models;

import com.rauf.interfaces.Board;
import com.rauf.interfaces.Food;
import com.rauf.interfaces.Snake;


public class CollisionDetector {

    public static boolean collisionWithBoundary (Snake snake) {

        return snake.getX(0) > Board.width ||
                snake.getX(0) < 0 ||
                snake.getY(0) > Board.width ||
                snake.getY(0) < 0;
    }

    public static boolean collisionWithFood(Snake snake, Food food) {
        return snake.getX(0) == food.getX() && snake.getY(0) == food.getY();
    }

    public static boolean collisionWithBody(Snake snake) {
        for (int i = 2; i < snake.getLength(); i++) {
            if(snake.getLength() > 4 && snake.getX(0) == snake.getX(i) && snake.getY(0) == snake.getY(i)) {
                System.out.println("i = " + i);
                return true;
            }
        }
        return false;
    }


}
