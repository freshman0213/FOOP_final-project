package flyingObject.bullet;

import flyingObject.Bullet;
import model.SpriteShape;

import java.awt.*;
import java.util.List;

import static utils.ImageStateUtils.imagesFromFolder;

public class StrongerBullet extends Bullet {
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(16, 16), new Dimension(0, 0), new Dimension(16, 16));
    public static int DAMAGE = 50;
    public static List<Image> IMAGES = imagesFromFolder("assets/strongerBullet");

    public StrongerBullet(Dimension movement, Point location) {
        super(SHAPE, movement, IMAGES, DAMAGE);
        this.location = location;
    }

    @Override
    public Bullet copy(Dimension movement, Point location) {
        return new StrongerBullet(movement, location);
    }
}
