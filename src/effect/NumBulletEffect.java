package effect;

import livingObject.LivingObject;
import livingObject.bulletMovement.NormalBulletsMovementState;
import warplane.Warplane;

public class NumBulletEffect implements Effect {
    private int numBullet;
    private int length;

    public NumBulletEffect(int numBullet, int length) {
        this.numBullet = numBullet;
        this.length = length;
    }

    @Override
    public void apply(LivingObject livingObject) {
        int direction;
        if (livingObject instanceof Warplane) {
            direction = -1;
        }
        else {
            direction = 1;
        }
        livingObject.changeBulletMovement(new NormalBulletsMovementState(length, livingObject, numBullet, direction));
    }
}
