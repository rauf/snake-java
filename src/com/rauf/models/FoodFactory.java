package com.rauf.models;

import com.rauf.interfaces.Food;

import javax.swing.*;


public class FoodFactory {

    private static int gap = 20;

    public static Food getBaseFood() {

        return new BaseFood(new ImageIcon("food.png").getImage(), RandomProvider.getRandomPointX(gap), RandomProvider.getRandomPointY(gap));
    }

}
