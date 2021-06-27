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
    public static Bullet BULLET = new NormalBullet(new Dimension(0, 0), new Point(0, 0)); // dummy bullet to represent default bullet (not add to the world -> not going to be called)
    public static int NUMBULLET = 1;
    public static int VELOCITY = 3;
    public static SpriteShape SHAPE = new SpriteShape(new Dimension(142, 100), new Dimension(44, 10), new Dimension(75, 82));
    public static List<Image> IDLEIMAGES = imagesFromFolder("assets/normalWarplane/idle");
    public static List<Image> WALKINGIMAGES = imagesFromFolder("assets/normalWarplane/walking");

    public NormalWarplane(Point location) {
        super(HP, CD, BULLET, NUMBULLET, VELOCITY, SHAPE, IDLEIMAGES, WALKINGIMAGES);
        this.location = location;
    }

    @Override
    public void fire() {
        Rectangle range = getRange();
        Point location = new Point(range.x + 72, range.y + 9);
        for (Dimension movement : current_bulletMovement.getMovements()) {
            Bullet bullet = current_bullet.getBullet().copy(movement, location);
            this.world.addSprite(bullet);
        }
    }
}