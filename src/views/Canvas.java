package views;

import javax.swing.JPanel;

import controller.Game;
import java.awt.event.*;
import java.awt.*;

import model.Direction;
import model.World;

public class Canvas extends JPanel implements View {
    private World world;
    private Game game;

    public Canvas(Game game){
        this.game = game;
        addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_W:
                        game.moveWarplane(Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        game.moveWarplane(Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        game.moveWarplane(Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        game.moveWarplane(Direction.RIGHT);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                // TODO Auto-generated method stub
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_W:
                        game.stopWarplane(Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        game.stopWarplane(Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        game.stopWarplane(Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        game.stopWarplane(Direction.RIGHT);
                        break;
                }
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void render(World world) {
        this.world = world;
        repaint(); // ask the JPanel to repaint, it will invoke paintComponent(g) after a while.
    }

    @Override
    protected void paintComponent(Graphics g /*paintbrush*/) {
        super.paintComponent(g);
        //Get focus 
        setFocusable(true);
        requestFocusInWindow();
        //Paint
        g.setColor(Color.WHITE); // paint background with all white
        g.fillRect(0, 0, GameView.WIDTH, GameView.HEIGHT);

        world.render(g); // ask the world to paint itself and paint the sprites on the canvas
    }
}
