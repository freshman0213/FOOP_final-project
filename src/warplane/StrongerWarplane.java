package warplane;

import flyingObject.Bullet;
import flyingObject.bullet.NormalBullet;
import model.SpriteShape;

import java.awt.*;
import java.util.List;

import static utils.ImageStateUtils.imagesFromFolder;

public class StrongerWarplane extends Warplane {
    public static int HP = 5000;
    public static int CD = 30;
    public static Bullet BULLET = new NormalBullet(new Dimension(0, 0), new Point(0, 0)); // dummy bullet to represent default bullet (not add to the world -> not going to be called)
    public static int NUMBULLET = 3;
    public static int VELOCITY = 15;
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(83, 118), new Dimension(6, 7), new Dimension(70, 100));
    public static java.util.List<Image> IDLEIMAGES = imagesFromFolder("assets/strongerWarplane");
    public static List<Image> WALKINGIMAGES = imagesFromFolder("assets/strongerWarplane");

    public StrongerWarplane(Point location) {
        super(HP, CD, BULLET, NUMBULLET, VELOCITY, SHAPE, IDLEIMAGES, WALKINGIMAGES);
        this.location = location;
    }
}
