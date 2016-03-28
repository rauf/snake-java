package com.rauf.models;

import com.rauf.interfaces.Board;
import com.rauf.interfaces.Snake;

import java.awt.*;


public class CrossBoard implements Board {

    public static int lineDistance = Snake.pieceHeight;

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
/*

        int dis = Math.max(width / lineDistance, height / lineDistance);
        int temp = 0;


        for (int i = 0; i < dis; i++) {
            g2.drawLine( temp, 0, temp, height);
            g2.drawLine( 0, temp, width, temp);
            temp += lineDistance;
        }
*/

    }

}
