package boss;

import flyingObject.Bullet;
import livingObject.LivingObject;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

public abstract class Boss extends LivingObject { // template for all bosses

    public Boss(int hp, int cd, Bullet bullet, int numBullet, int velocity, SpriteShape shape, List<Image> idleImages, List<Image> walkingImages) {
        super(hp, cd, bullet, numBullet, velocity, shape, idleImages, walkingImages);

        // TODO: set up Runnable object to automatically move bosses
    }
}
