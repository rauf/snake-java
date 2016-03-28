package com.rauf.interfaces;


public interface Food extends Drawable{

    public static int foodWidth = Snake.pieceWidth;
    public static int foodHeight = Snake.pieceHeight;

    public int getX();
    public int getY();
}
