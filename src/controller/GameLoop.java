package controller;

import model.World;
import views.View;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class GameLoop {
    protected boolean running;
    protected View view;

    public void setView(View view) {
        this.view = view;
    }

    public void start() {
        new Thread(this::gameLoop).start();
    }

    protected void gameLoop() {
        running = true;
        while (running) {
            World world = getWorld();
            world.update();
            view.renderWorld(world);
            delay(15);
        }
    }

    protected abstract World getWorld();

    protected void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
