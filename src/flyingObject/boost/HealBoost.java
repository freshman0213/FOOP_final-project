package flyingObject.boost;

import effect.HealEffect;
import flyingObject.Boost;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class HealBoost extends Boost {
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(50, 60), new Dimension(6, 9), new Dimension(36, 36));
    public static List<Image> IMAGES = imagesFromFolder("assets/healBoost");

    public HealBoost(Point location) {
        super(SHAPE, IMAGES);
        this.location = location;
        this.effects.add(new HealEffect(1000));
    }

    @Override
    public Boost copy(Point location) {
        return new HealBoost(location);
    }
}
