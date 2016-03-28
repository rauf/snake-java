package com.rauf.models;

import com.rauf.interfaces.Food;

import java.awt.*;


public class BaseFood implements Food{

    private int x;
    private int y;
    private Image image;

    public BaseFood(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, x, y, Food.foodWidth, Food.foodHeight, null);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

}
