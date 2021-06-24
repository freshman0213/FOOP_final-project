package flyingObject.bullet;

import flyingObject.Bullet;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class NormalBullet extends Bullet {
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(), new Dimension(), new Dimension());
    public static int DAMAGE = 20;
    public static List<Image> IMAGES = imagesFromFolder("");

    public NormalBullet(Dimension movement, Point location) {
        super(SHAPE, movement, IMAGES, DAMAGE);
        this.location = location;
    }
}
