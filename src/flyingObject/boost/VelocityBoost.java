package flyingObject.boost;

import effect.VelocityEffect;
import flyingObject.Boost;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class VelocityBoost extends Boost {
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(64, 64), new Dimension(0, 0), new Dimension(64, 64));
    public static List<Image> IMAGES = imagesFromFolder("assets/velocityBoost");

    public VelocityBoost(Point location) {
        super(SHAPE, IMAGES);
        this.location = location;
        this.effects.add(new VelocityEffect(50, 500));
    }

    @Override
    public Boost copy(Point location) {
        return new VelocityBoost(location);
    }
}
