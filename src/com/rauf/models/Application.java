package com.rauf.models;


import com.rauf.interfaces.Board;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


class Application extends JFrame{

    public void initUI() throws IOException {

        BaseGame game = new BaseGame();
        add(game);
        setTitle("Snake Game");
        setSize(Board.width, Board.height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater( () -> {
                Application ap = new Application();
            try {
                ap.initUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ap.setVisible(true);
        });


    }
}
