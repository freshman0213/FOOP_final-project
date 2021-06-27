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
    private boolean angry = false;

    public Boss(int hp, int cd, Bullet bullet, int numBullet, int velocity, SpriteShape shape, List<Image> idleImages, List<Image> walkingImages) {
        super(hp, cd, bullet, numBullet, 1, velocity, shape, idleImages, walkingImages);
    }

    @Override
    public void update() {
        super.update();
        // angry mode
        if (getHP() < 200 && !angry) {
            angry = true;
            current_cd = new NormalCDState(1000, this, 2);
            current_bulletMovement = new NormalBulletsMovementState(1000, this, 5, 1);
            current_velocity = new NormalVelocityState(1000, this, 10);
        }
    }
}
