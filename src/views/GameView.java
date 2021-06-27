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
    public static final int HEIGHT = 1000;
    public static final int WIDTH = 1000;
    private final Canvas canvas;
    private final StartCanvas startCanvas;
    private final Game game;

    public GameView(Game game) throws HeadlessException {
        this.game = game;
        this.startCanvas = new StartCanvas(game, this);
        this.canvas = new Canvas(game);
        game.setView(canvas);
        start();
    }

    public void start() {
        // add start canvas to frame 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setContentPane(startCanvas);
        setVisible(true);
    }

    public void launch() {
        // launch main game canvas panel
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(canvas);
        setSize(WIDTH, HEIGHT);
        setContentPane(canvas);
        setVisible(true);
    }
}

