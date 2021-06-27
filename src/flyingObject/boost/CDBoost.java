package flyingObject.boost;

import effect.CDEffect;
import flyingObject.Boost;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class CDBoost extends Boost {
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(), new Dimension(), new Dimension());
    public static List<Image> IMAGES = imagesFromFolder("assets/cdBoost");

    public CDBoost(Point location) {
        super(SHAPE, IMAGES);
        this.location = location;
        this.effects.add(new CDEffect(2));
    }
}
