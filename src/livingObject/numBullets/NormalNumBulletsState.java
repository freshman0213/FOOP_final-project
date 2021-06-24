package livingObject.numBullets;

import livingObject.LivingObject;
import livingObject.StatusState;

import java.awt.*;

import static livingObject.LivingObject.Status.*;

public class NormalNumBulletsState implements NumBulletState {
    private int state_remaining;
    private final LivingObject livingObject;
    private final int numBullets;
    private final Image image;

    public NormalNumBulletsState(int lasting_time, LivingObject livingObject, int numBullets, Image image) {
        this.state_remaining = lasting_time;
        this.livingObject = livingObject;
        this.numBullets = numBullets;
        this.image = image;
    }

    @Override
    public StatusState copy() {
        return new NormalNumBulletsState(this.state_remaining, this.livingObject, this.numBullets, this.image);
    }

    @Override
    public int getNumBullet() {
        return numBullets;
    }

    @Override
    public void update() {
        if (state_remaining > 0) {
            state_remaining --;
            if (state_remaining == 0) {
                livingObject.reset(NumBullets);
            }
        }
    }

    @Override
    public void render(Graphics g) {}
}
