package warplane.bullet;

import fsm.ImageRenderer;
import flyingObjects.Bullet;
import warplane.StatusState;
import warplane.Warplane;

import java.awt.*;

import static warplane.Warplane.Status.*;

public class NormalBulletState implements BulletState {
    private int state_remaining;
    private final Warplane warplane;
    private final Bullet bullet;
    private final Image image;
    private final ImageRenderer imageRenderer;

    public NormalBulletState(int lasting_time, Warplane warplane, Bullet bullet, Image image, ImageRenderer imageRenderer) {
        this.state_remaining = lasting_time;
        this.warplane = warplane;
        this.bullet = bullet;
        this.image = image;
        this.imageRenderer = imageRenderer;
    }

    @Override
    public StatusState copy() {
        return new NormalBulletState(this.state_remaining, this.warplane, this.bullet, this.image, this.imageRenderer);
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
                warplane.reset(Bullet);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        imageRenderer.render(image, g);
    }
}
