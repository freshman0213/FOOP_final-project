package flyingObject.boost;

import effect.BulletEffect;
import flyingObject.Boost;
import flyingObject.Bullet;
import flyingObject.bullet.StrongerBullet;
import model.SpriteShape;

import java.awt.*;
import java.util.List;

import static utils.ImageStateUtils.imagesFromFolder;

public class BulletBoost extends Boost {
    private static SpriteShape SHAPE = new SpriteShape(new Dimension(50, 60), new Dimension(6, 9), new Dimension(36, 36));
    private static List<Image> IMAGES = imagesFromFolder("assets/BulletBoost"); // images for the circle outside
    public static Bullet bullet = new StrongerBullet(new Dimension(0, 0), new Point(0, 0));

    public BulletBoost(Point location) {
        super(SHAPE, IMAGES);
        this.location = location;
        this.effects.add(new BulletEffect(bullet, 500));
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        Rectangle boostBody = getBody();
        Rectangle bulletRange = bullet.getRange();
        Rectangle bulletBody = bullet.getBody();
        Dimension bulletOffset = bullet.getBodyOffset();
        g.drawImage(bullet.getImage(), boostBody.x + (boostBody.width / 2) - (bulletBody.width / 2) - bulletOffset.width,
                boostBody.y + (boostBody.height / 2) - (bulletBody.height / 2) - bulletOffset.height,
                bulletRange.width, bulletRange.height, null);
    }

    @Override
    public Boost copy(Point location) {
        return new BulletBoost(location);
    }
}
