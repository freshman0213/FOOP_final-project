package flyingObject.bullet;

import flyingObject.Bullet;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class NormalBullet extends Bullet {
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(96, 96), new Dimension(40, 8), new Dimension(16, 16));
    public static int DAMAGE = 20;
    public static List<Image> IMAGES = imagesFromFolder("assets/normalBullet");

    public NormalBullet(Dimension movement, Point location) {
        super(SHAPE, movement, IMAGES, DAMAGE);
        this.location = location;
    }

    @Override
    public Bullet copy(Dimension movement, Point location) {
        return new NormalBullet(movement, location);
    }
}
