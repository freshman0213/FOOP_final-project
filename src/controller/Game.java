package controller;

import knight.Knight;
import model.Direction;
import model.World;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Game extends GameLoop {
    private final WarPlane warPlane;
    private final World world;

    public Game(World world, WarPlane warPlane) {
        this.warPlane = warPlane;
        this.world = world;
    }

    public void moveKnight(Direction direction) {
        warPlane.move(direction);
    }

    public void stopKnight(Direction direction) {
        warPlane.stop(direction);
    }

    @Override
    protected World getWorld() {
        return world;
    }
}
