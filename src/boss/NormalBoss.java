package boss;

import flyingObject.Bullet;
import flyingObject.bullet.NormalBullet;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class NormalBoss extends Boss {
    public static int HP = 1000;
    public static int CD = 50;
    public static Bullet BULLET = new NormalBullet(new Dimension(0, 0), new Point(0, 0)); // dummy bullet represents default bullet
    public static int NUMBULLET = 1;
    public static int VELOCITY = 3;
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(177, 175), new Dimension(34, 31), new Dimension(90, 123));
    public static List<Image> IDLEIMAGES = imagesFromFolder("assets/normalBoss/idle");
    public static List<Image> WALKINGIMAGES = imagesFromFolder("assets/normalBoss/walking");

    public NormalBoss(Point location) {
        super(HP, CD, BULLET, NUMBULLET, VELOCITY, SHAPE, IDLEIMAGES, WALKINGIMAGES);
        this.location = location;
    }
}
