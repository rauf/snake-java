package com.rauf.interfaces;


public interface Snake extends Drawable{

    int pieceHeight = 15;
    int pieceWidth = 15;

    int LEFT = 123;
    int UP = 124;
    int DOWN = 125;
    int RIGHT = 126;

    void eat(Food food);
    void move(int m);
    int getLength();
    int getDirection();
    void setDirection(int direction);
    int getX(int k);
    int getY(int k);
}
