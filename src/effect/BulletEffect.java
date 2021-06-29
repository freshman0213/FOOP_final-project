package effect;

import flyingObject.Bullet;
import livingObject.LivingObject;
import livingObject.bullet.NormalBulletState;

public class BulletEffect implements Effect {
    // TODO: how to display bullet effect
    private Bullet bullet;
    private int length;

    public BulletEffect(Bullet bullet, int length) {
        this.bullet = bullet;
        this.length = length;
    }

    @Override
    public void apply(LivingObject livingObject) {
        livingObject.changeBullet(new NormalBulletState(length, livingObject, bullet));
    }
}
