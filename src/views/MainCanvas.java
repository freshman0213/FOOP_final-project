package views;

import controller.Game;
import java.awt.event.*;
import java.awt.*;

import model.Direction;
import model.World;

public class MainCanvas extends Canvas implements View {

    public MainCanvas(Game game, GameView gameView, String path){
        super(game, gameView, path);
        addEventListener();
    }

    private void addEventListener(){
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
    }
    
    @Override
    public void render() {}

    @Override
    protected void paintComponent(Graphics g ) {
        super.paintComponent(g);
        //Get focus of keyboard
        setFocusable(true);
        requestFocusInWindow();
    
        background.render(g);
        background.update();

        world.render(g); // ask the world to paint itself and paint the sprites on the canvas
    }

    @Override
    public void win(){
        gameView.win();
    }

    @Override
    public void lose(){
        gameView.lose();
    }

    @Override
    public void renderWorld(World world) {
        this.world = world;
        repaint(); // ask the JPanel to repaint, it will invoke paintComponent(g) after a while.
    }
}