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

    @Override
    public void fire() {
        Rectangle body = getBody();
        Bullet bullet = current_bullet.getBullet();
        for (Dimension movement : current_bulletMovement.getMovements()) {
            Point location = new Point(body.x + (body.width / 2) - (bullet.getBodySize().width / 2) - bullet.getBodyOffset().width, body.y - 1 - bullet.getBodySize().height - 8);
            Bullet new_bullet = bullet.copy(movement, location);
            this.world.addSprite(new_bullet);
        }
    }
}
