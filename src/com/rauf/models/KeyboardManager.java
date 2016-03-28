package com.rauf.models;

import com.rauf.interfaces.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class KeyboardManager  {

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String MOVE_UP = "move up";
    private static final String MOVE_DOWN = "move down";
    private static final String MOVE_LEFT = "move left";
    private static final String MOVE_RIGHT = "move right";

    private static final String MOVE = "move";

    BaseGame game;
    Snake snake;

    public KeyboardManager(BaseGame game, Snake snake) {
        this.game = game;
        this.snake = snake;

        game.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
        game.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
        game.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
        game.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);

        game.getActionMap().put(MOVE_UP, actionUp);
        game.getActionMap().put(MOVE_DOWN, actionDown);
        game.getActionMap().put(MOVE_LEFT, actionLeft);
        game.getActionMap().put(MOVE_RIGHT, actionRight);
    }

    private Action actionUp = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(snake.getDirection() != Snake.DOWN)
                snake.setDirection(Snake.UP);
        }
    };

    private Action actionDown = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(snake.getDirection() != Snake.UP)
                snake.setDirection(Snake.DOWN);
        }
    };

    private Action actionLeft = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(snake.getDirection() != Snake.RIGHT)
                snake.setDirection(Snake.LEFT);
        }
    };

    private Action actionRight = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(snake.getDirection() != Snake.LEFT)
                snake.setDirection(Snake.RIGHT);
        }
    };

}
