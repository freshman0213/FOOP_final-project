package warplane.numBullets;

import fsm.ImageRenderer;
import warplane.StatusState;
import warplane.Warplane;

import java.awt.*;

import static warplane.Warplane.Status.*;

public class NormalNumBulletsState implements NumBulletState {
    private int state_remaining;
    private final Warplane warplane;
    private final int numBullets;
    private final Image image;
    private final ImageRenderer imageRenderer;

    public NormalNumBulletsState(int lasting_time, Warplane warplane, int numBullets, Image image, ImageRenderer imageRenderer) {
        this.state_remaining = lasting_time;
        this.warplane = warplane;
        this.numBullets = numBullets;
        this.image = image;
        this.imageRenderer = imageRenderer;
    }

    @Override
    public StatusState copy() {
        return new NormalNumBulletsState(this.state_remaining, this.warplane, this.numBullets, this.image, this.imageRenderer);
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
                warplane.reset(NumBullets);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        imageRenderer.render(image, g);
    }
}
