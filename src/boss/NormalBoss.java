package boss;

import flyingObject.Bullet;
import flyingObject.bullet.NormalBullet;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class NormalBoss extends Boss {
    public static int HP = 800;
    public static int CD = 3;
    public static Bullet BULLET = new NormalBullet();
    public static int NUMBULLET = 1;
    public static int VELOCITY = 3;
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(), new Dimension(), new Dimension());
    public static List<Image> IDLEIMAGES = imagesFromFolder("");
    public static List<Image> WALKINGIMAGES = imagesFromFolder("");

    public NormalBoss(Point location) {
        super(HP, CD, BULLET, NUMBULLET, VELOCITY, SHAPE, IDLEIMAGES, WALKINGIMAGES);
        this.location = location;
    }

    @Override
    public void fire() {
        // TODO: location
        Point location = new Point();
        for (Dimension movement : current_bulletMovement.getMovements()) {
            Bullet bullet = current_bullet.getBullet().copy(movement, location);
            this.world.addSprite(bullet);
        }
    }
}
