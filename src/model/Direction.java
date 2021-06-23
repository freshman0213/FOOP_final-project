package model;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public Dimension translate(int velocity) {
        switch (this) {
            case UP:
                return new Dimension(0, -velocity);
            case DOWN:
                return new Dimension(0, velocity);
            case LEFT:
                return new Dimension(-velocity, 0);
            case RIGHT:
                return new Dimension(velocity, 0);
            default:
                throw new IllegalStateException("Impossible");
        }
    }
}
