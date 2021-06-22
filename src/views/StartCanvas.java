package views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Game;

public class StartCanvas extends JPanel{
    private Game game;
    private GameView gameView;

    public StartCanvas(Game game , GameView gameView){
        this.game = game;
        this.gameView = gameView;
        this.setLayout(null); //use absolute layout
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
                        System.out.println("press");
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

    public void render(){
        System.out.println("paint start view");
        setSize(GameView.WIDTH, GameView.HEIGHT);
        setBackground(Color.GRAY);
        
        JLabel label = new JLabel("Press Enter To Start");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setBounds(GameView.WIDTH * 3 / 8, GameView.HEIGHT / 8, GameView.WIDTH * 2 / 8, GameView.HEIGHT / 8);
        label.setForeground(Color.BLUE);
        add(label);
    }
}
