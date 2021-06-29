package views;

import controller.Game;

import javax.swing.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class GameView extends JFrame {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 600;
    private final MainCanvas mainCanvas;
    private BackgroundCanvas backgroundCanvas;
    private final Game game;

    public GameView(Game game){
        this.game = game;
        this.mainCanvas = new MainCanvas(game, this,  "assets/gameBackground");
        game.setView(mainCanvas);
        start();
    }

    public void start() {
        backgroundCanvas = new BackgroundCanvas(game, this, "assets/startBackground");
        setCanvas(backgroundCanvas);
    }

    public void launch() {
        setCanvas(mainCanvas);
    }

    public void win() {
        backgroundCanvas = new BackgroundCanvas(game, this, "assets/winBackground");
        setCanvas(backgroundCanvas);
    }

    public void lose() {
        backgroundCanvas = new BackgroundCanvas(game, this, "assests/loseBackground");
        setCanvas(backgroundCanvas);
    }

    private void setCanvas(Canvas canvas){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setContentPane(canvas);
        setVisible(true);
    }
}

