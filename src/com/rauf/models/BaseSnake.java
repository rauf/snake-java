package com.rauf.models;

import com.rauf.interfaces.Board;
import com.rauf.interfaces.Food;
import com.rauf.interfaces.Snake;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class BaseSnake implements Snake{

    private int direction = LEFT;
    private int gap = 20;       //to avoid boundaries
    private Image bodyImage;
    private Image headImage;
    private int x[];
    private int y[];
    private int length;

    public BaseSnake() throws IOException {

        x = new int[Board.height * Board.width / pieceWidth];
        y = new int[Board.height * Board.width / pieceHeight];

        headImage = new ImageIcon("head.png").getImage();
        bodyImage = new ImageIcon("body.png").getImage();

        //adding head piece
        x[0] = RandomProvider.getRandomPointX(gap);
        y[0] = RandomProvider.getRandomPointY(gap);
        length++;
        int temp = x[0];

        //horizontal snake
        for (int j = 1; j < 4; j++) {
            temp += pieceWidth;
            x[j] = temp;
            y[j] = y[0];
            length++;
        }
    }

    public int getLength(){
        return length;
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < length; i++) {
            if(i == 0)
                g2.drawImage(headImage, x[0], y[0], pieceWidth, pieceHeight, null);

            else g2.drawImage(bodyImage, x[i], y[i], pieceWidth, pieceHeight, null);
        }

    }


    public void move(int mov) {

        for (int i = length; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (mov) {

            case LEFT:
                if(direction == RIGHT)  return;
                x[0] -= pieceWidth;
                direction = LEFT;
                break;

            case RIGHT:
                if(direction == LEFT)  return;
                x[0] += pieceWidth;
                direction = RIGHT;
                break;

            case UP:
                if(direction == DOWN)  return;
                y[0] -= pieceHeight;
                direction = UP;
                break;

            case DOWN:
                if(direction == UP)  return;
                y[0] += pieceHeight;
                direction = DOWN;
                break;
        }

    }

    public void eat(Food food) {

        length++;

        for (int i = length; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        x[0] = food.getX();
        y[0] = food.getY();
    }

    public int getX(int k) {
        return x[k];
    }

    public int getY(int k) {
        return y[k];
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
