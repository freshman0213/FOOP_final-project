package boss;

import flyingObject.Bullet;
import flyingObject.bullet.StrongerBullet;
import model.SpriteShape;

import java.awt.*;
import java.util.List;

import static utils.ImageStateUtils.imagesFromFolder;

public class StrongerBoss extends Boss {
    public static int HP = 3000;
    public static int CD = 30;
    public static Bullet BULLET = new StrongerBullet(new Dimension(0, 0), new Point(0, 0)); // dummy bullet represents default bullet
    public static int NUMBULLET = 3;
    public static int VELOCITY = 8;
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(99, 170), new Dimension(3, 4), new Dimension(90, 137));
    public static java.util.List<Image> IDLEIMAGES = imagesFromFolder("assets/strongerBoss");
    public static List<Image> WALKINGIMAGES = imagesFromFolder("assets/strongerBoss");

    public StrongerBoss(Point location) {
        super(HP, CD, BULLET, NUMBULLET, VELOCITY, SHAPE, IDLEIMAGES, WALKINGIMAGES);
        this.location = location;
    }
}
