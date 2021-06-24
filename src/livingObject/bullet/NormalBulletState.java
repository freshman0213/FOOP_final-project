package livingObject.bullet;

import flyingObject.Bullet;
import livingObject.StatusState;
import livingObject.LivingObject;

import java.awt.*;

import static livingObject.LivingObject.Status.*;

public class NormalBulletState implements BulletState {
    private int state_remaining;
    private final LivingObject livingObject;
    private final Bullet bullet;
    private final Image image;

    public NormalBulletState(int lasting_time, LivingObject livingObject, Bullet bullet, Image image) {
        this.state_remaining = lasting_time;
        this.livingObject = livingObject;
        this.bullet = bullet;
        this.image = image;
    }

    @Override
    public StatusState copy() {
        return new NormalBulletState(this.state_remaining, this.livingObject, this.bullet, this.image);
    }

    @Override
    public Bullet getBullet() {
        return bullet;
    }

    @Override
    public void update() {
        if (state_remaining > 0) {
            state_remaining --;
            if (state_remaining == 0) {
                livingObject.reset(Bullet);
            }
        }
    }

    @Override
    public void render(Graphics g) {}
}
