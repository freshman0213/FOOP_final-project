package controller;

import boss.Boss;
import model.Direction;
import model.World;
import warplane.Warplane;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Game extends GameLoop {
    private final Warplane warplane;
    private final World world;
    private final Boss boss;

    public Game(World world, Warplane warplane, Boss boss) {
        this.warplane = warplane;
        this.world = world;
        this.boss = boss;
    }

    public void moveWarplane(Direction direction) {
        warplane.move(direction);
    }

    public void stopWarplane(Direction direction) {
        warplane.stop(direction);
    }

    public void moveBoss(Direction direction) {
        boss.move(direction);
    }

    public void stopBoss(Direction direction) {
        boss.stop(direction);
    }

    @Override
    protected World getWorld() {
        return world;
    }
}
