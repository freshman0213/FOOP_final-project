package flyingObject.boost;

import flyingObject.Boost;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class CDBoost extends Boost {
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(), new Dimension(), new Dimension());
    public static List<Image> IMAGES = imagesFromFolder("");

    public CDBoost(Point location) {
        super(SHAPE, IMAGES);
        this.location = location;
        // TODO: add effects
    }
}
