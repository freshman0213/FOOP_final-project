package boss;

import ai.MoveAI;
import flyingObject.Bullet;
import livingObject.LivingObject;
import livingObject.bulletMovement.NormalBulletsMovementState;
import livingObject.cd.NormalCDState;
import livingObject.velocity.NormalVelocityState;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

public abstract class Boss extends LivingObject { // template for all bosses

    public Boss(int hp, int cd, Bullet bullet, int numBullet, int velocity, SpriteShape shape, List<Image> idleImages, List<Image> walkingImages) {
        super(hp, cd, bullet, numBullet, 1, velocity, shape, idleImages, walkingImages);
    }

    @Override
    public void update() {
        super.update();
        // angry mode
        if (getHP() < 50) {
            current_cd = new NormalCDState(20, this, 2);
            current_bulletMovement = new NormalBulletsMovementState(20, this, 5, 1);
            current_velocity = new NormalVelocityState(20, this, 10);
        }
    }
}
