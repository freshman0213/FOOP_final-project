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
    public static final int HEIGHT = 600;
    public static final int WIDTH = 600;
    private final MainCanvas canvas;
    private final StartCanvas startCanvas;
    private final Game game;

    public GameView(Game game){
        this.game = game;
        this.startCanvas = new StartCanvas(game, this, "assets/startBackground");
        this.canvas = new MainCanvas(game, this,  "assets/gameBackground");
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

    public void win() {

    }

    public void lose() {

    }
}

