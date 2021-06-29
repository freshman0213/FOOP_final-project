package views;

import java.awt.*;
import java.awt.event.*;

import controller.Game;

public class BackgroundCanvas extends Canvas{
    
    public BackgroundCanvas(Game game , GameView gameView, String path){
        super(game, gameView, path);
        addEventListener();
        render();
    }

    private void addEventListener(){
        addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        game.start();
                        gameView.launch();
                        setFocusable(false);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.render(g);
    }

    @Override
    public void render() {
        setSize(GameView.WIDTH, GameView.HEIGHT);
        repaint(); //call paintComponent();
    }
}
