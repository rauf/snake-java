package com.rauf.models;

import com.rauf.interfaces.Board;
import com.rauf.interfaces.Drawable;
import com.rauf.interfaces.Snake;

import java.awt.*;


public class Informer implements Drawable {

    private boolean inGame;

    private Snake snake;
    private int gap;
    private int score;

    public Informer(Snake snake, int gap) {
        this.snake = snake;
        this.gap = gap;
        this.inGame = true;
    }

    public Informer(Snake snake) {
        this(snake,10);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if(inGame)
            counter(g2);

        else onGameOver(g2);
    }


    private void counter(Graphics2D g2) {
        g2.setFont(new Font(g2.getFont().getFontName(), Font.PLAIN, 15));
        g2.drawString(String.valueOf(score), gap, 2* gap);
    }

    private void onGameOver(Graphics2D g2){

        String overStr = "Game Over !!!";
        String scoreStr = "Your score is ";

        g2.setFont(new Font(g2.getFont().getFontName(), Font.PLAIN, 40));
        int widthOver = g2.getFontMetrics().stringWidth(overStr);

        g2.drawString(overStr, (Board.width - widthOver) / 2, Board.height / 2);

        g2.setFont(new Font(g2.getFont().getFontName(), Font.PLAIN, 20));
        int widthScore = g2.getFontMetrics().stringWidth(scoreStr);
        g2.drawString( scoreStr + score , (Board.width - widthScore) / 2, Board.height / 2 + 40);
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
