package com.rauf.models;

import com.rauf.interfaces.Board;
import com.rauf.interfaces.Food;
import com.rauf.interfaces.Snake;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class BaseGame extends JPanel{

    private Board board;
    private Snake snake;
    private Food food;
    private KeyboardManager kbManager;
    private Informer informer;
    private Timer timer;
    private int DELAY = 150;
    private int score;

    public BaseGame() throws IOException {
        board = new CrossBoard();
        snake = new BaseSnake();
        food = FoodFactory.getBaseFood();
        informer = new Informer(snake);
        kbManager = new KeyboardManager(this, snake);
        this.score = 0;

        timer = new Timer(DELAY, e -> {

            if(CollisionDetector.collisionWithBody(snake) || CollisionDetector.collisionWithBoundary(snake)) {
                informer.setInGame(false);
                timer.stop();
            }

            if(informer.isInGame()) {
                snake.move(snake.getDirection());
            }
            if(CollisionDetector.collisionWithFood(snake, food)) {
                snake.eat(food);
                informer.setScore(++score);
                food = FoodFactory.getBaseFood();
            }

            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.draw(g);
        snake.draw(g);
        food.draw(g);
        informer.draw(g);
    }

}
