package warplane;

import flyingObject.Bullet;
import flyingObject.bullet.NormalBullet;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class NormalWarplane extends Warplane {
    public static int HP = 500;
    public static int CD = 5;
    public static Bullet BULLET = new NormalBullet(new Dimension(), new Point()); // dummy bullet to represent default bullet
    public static int NUMBULLET = 1;
    public static int VELOCITY = 3;
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(), new Dimension(), new Dimension());
    public static List<Image> IDLEIMAGES = imagesFromFolder("");
    public static List<Image> WALKINGIMAGES = imagesFromFolder("");

    public NormalWarplane(Point location) {
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
