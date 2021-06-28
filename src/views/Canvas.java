package views;

import javax.swing.JPanel;

import controller.Game;
import model.World;

public abstract class Canvas extends JPanel {
    protected World world;
    protected Game game;
    protected GameView gameView;
    protected Background background;

    public Canvas(Game game, GameView gameView, String path){
        this.game = game;
        this.gameView = gameView;
        this.background = new Background(path);
        setFocusable(true);
        requestFocusInWindow();
    }

    public abstract void render();

}
