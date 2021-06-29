package flyingObject.boost;

import effect.NumBulletEffect;
import flyingObject.Boost;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class NumBulletBoost extends Boost {
    private static SpriteShape SHAPE = new SpriteShape(new Dimension(50, 60), new Dimension(6, 9), new Dimension(36, 36));
    private static List<Image> IMAGES = imagesFromFolder("assets/numBulletBoost");

    public NumBulletBoost(Point location) {
        super(SHAPE, IMAGES);
        this.location = location;
        this.effects.add(new NumBulletEffect(4, 500));
    }

    @Override
    public Boost copy(Point location) {
        return new NumBulletBoost(location);
    }
}
