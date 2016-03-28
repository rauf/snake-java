package com.rauf.models;

import com.rauf.interfaces.Board;

import java.util.concurrent.ThreadLocalRandom;


public class RandomProvider {

    public static int getRandomPointX(int gap) {
        int rand = ThreadLocalRandom.current().nextInt( gap, Board.width -gap + 1);
        int tx = rand / BaseSnake.pieceWidth;
        return tx * BaseSnake.pieceWidth;
    }

    public static int getRandomPointY(int gap) {
        int rand = ThreadLocalRandom.current().nextInt( 1, Board.height - gap + 1);
        int tx = rand / BaseSnake.pieceHeight;
        return tx * BaseSnake.pieceHeight;
    }
}
