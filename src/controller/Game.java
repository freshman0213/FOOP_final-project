package controller;

import model.Direction;
import model.World;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Game extends GameLoop {
    private final Warplane warplane;
    private final World world;

    public Game(World world, Warplane warplane) {
        this.warplane = warplane;
        this.world = world;
    }

    public void moveWarplane(Direction direction) {
        warplane.move(direction);
    }

    public void stopWarplane(Direction direction) {
        warplane.stop(direction);
    }

    @Override
    protected World getWorld() {
        return world;
    }
}
