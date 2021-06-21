package views;

import controller.Game;
import controller.GameLoop;
import model.Direction;
import model.Sprite;
import model.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collection;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class GameView extends JFrame {
    public static final int HEIGHT = 500;
    public static final int WIDTH = 500;
    private final Canvas canvas = new Canvas();
    private final Game game;

    public GameView(Game game) throws HeadlessException {
        this.game = game;
        game.setView(canvas);
    }

    public void launch() {
        // GUI Stuff
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(canvas);
        setSize(WIDTH, HEIGHT);
        setContentPane(canvas);
        setVisible(true);

        // Keyboard listener
        addKeyListener(new KeyAdapter() {
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
}

