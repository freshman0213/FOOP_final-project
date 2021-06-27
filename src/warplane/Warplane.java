package warplane;

import livingObject.LivingObject;
import flyingObject.Bullet;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

public abstract class Warplane extends LivingObject {
    public Warplane(int hp, int cd, Bullet bullet, int numBullet, int velocity, SpriteShape shape, List<Image> idleImages, List<Image> walkingImages) { // template for all warplanes
        super(hp, cd, bullet, numBullet, -1, velocity, shape, idleImages, walkingImages);
    }
}
