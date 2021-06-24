package flyingObject;

import model.SpriteShape;

import java.util.List;
import java.awt.*;

public abstract class Boost extends FlyingObjects {
    public static Dimension MOVEMENT = new Dimension(0, 5); // can only move downward

    public Boost(SpriteShape shape, List<Image> images) {
        super(shape, MOVEMENT, images);
    }
}
