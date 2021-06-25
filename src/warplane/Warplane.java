package warplane;

import livingObject.LivingObject;
import flyingObject.Bullet;
import model.SpriteShape;
import warplane.statusImageRenderer.BulletImageRenderer;
import warplane.statusImageRenderer.CDImageRenderer;
import warplane.statusImageRenderer.BulletMovementImageRenderer;
import warplane.statusImageRenderer.VelocityImageRenderer;

import java.util.List;
import java.awt.*;

public abstract class Warplane extends LivingObject {
    // for displaying status to player
    public static CDImageRenderer cdImageRenderer = new CDImageRenderer();
    public static BulletImageRenderer bulletImageRenderer = new BulletImageRenderer();
    public static BulletMovementImageRenderer bulletMovementImageRenderer = new BulletMovementImageRenderer();
    public static VelocityImageRenderer velocityImageRenderer = new VelocityImageRenderer();

    public Warplane(int hp, int cd, Bullet bullet, int numBullet, int velocity, SpriteShape shape, List<Image> idleImages, List<Image> walkingImages) { // template for all warplanes
        super(hp, cd, bullet, numBullet, -1, velocity, shape, idleImages, walkingImages);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        // display status
        cdImageRenderer.render(current_cd.getImage(), g);
        bulletImageRenderer.render(current_bullet.getImage(), g);
        bulletMovementImageRenderer.render(current_bulletMovement.getImage(), g);
        velocityImageRenderer.render(current_velocity.getImage(), g);
    }
}
