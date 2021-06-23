package warplane.velocity;

import fsm.ImageRenderer;
import warplane.StatusState;
import warplane.Warplane;

import java.awt.*;

import static warplane.Warplane.Status.*;

public class NormalVelocityState implements VelocityState {
    private int state_remaining;
    private final Warplane warplane;
    private final int velocity;
    private final Image image;
    private final ImageRenderer imageRenderer;

    public NormalVelocityState(int lasting_time, Warplane warplane, int velocity, Image image, ImageRenderer imageRenderer) {
        this.state_remaining = lasting_time;
        this.warplane = warplane;
        this.velocity = velocity;
        this.image = image;
        this.imageRenderer = imageRenderer;
    }

    public NormalVelocityState(NormalVelocityState from) { // copy constructor
        this.state_remaining = from.state_remaining;
        this.warplane = from.warplane;
        this.velocity = from.velocity;
        this.image = from.image;
        this.imageRenderer = from.imageRenderer;
    }

    @Override
    public StatusState copy() {
        return new NormalVelocityState(this.state_remaining, this.warplane, this.velocity, this.image, this.imageRenderer);
    }

    @Override
    public int getVelocity() {
        return velocity;
    }

    @Override
    public void update() {
        if (state_remaining > 0) {
            state_remaining --;
            if (state_remaining == 0) {
                warplane.reset(Velocity);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        imageRenderer.render(image, g);
    }
}
