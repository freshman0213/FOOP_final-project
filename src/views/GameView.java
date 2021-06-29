package views;

import controller.Game;

import javax.swing.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class GameView extends JFrame {
    public static final int HEIGHT = 1000;
    public static final int WIDTH = 1000;
    private final MainCanvas mainCanvas;
    private StartCanvas startCanvas;
    private final Game game;

    public GameView(Game game){
        this.game = game;
        this.mainCanvas = new MainCanvas(game, this,  "assets/gameBackground");
        game.setView(mainCanvas);
        start();
    }

    public void start() {
        startCanvas = new StartCanvas(game, this, "assets/startBackground");
        setCanvas(startCanvas);
    }

    public void launch() {
        setCanvas(mainCanvas);
    }

    public void win() {
        startCanvas = new StartCanvas(game, this, "assets/winBackground");
        setCanvas(startCanvas);
    }

    public void lose() {
        startCanvas = new StartCanvas(game, this, "assests/loseBackground");
        setCanvas(startCanvas);
    }

    private void setCanvas(Canvas canvas){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setContentPane(canvas);
        setVisible(true);
    }
}

