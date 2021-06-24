package livingObject.velocity;

import livingObject.LivingObject;
import livingObject.StatusState;

import java.awt.*;

import static livingObject.LivingObject.Status.*;

public class NormalVelocityState implements VelocityState {
    private int state_remaining;
    private final LivingObject livingObject;
    private final int velocity;
    private final Image image;

    public NormalVelocityState(int lasting_time, LivingObject livingObject, int velocity, Image image) {
        this.state_remaining = lasting_time;
        this.livingObject = livingObject;
        this.velocity = velocity;
        this.image = image;
    }

    @Override
    public StatusState copy() {
        return new NormalVelocityState(this.state_remaining, this.livingObject, this.velocity, this.image);
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
                livingObject.reset(Velocity);
            }
        }
    }

    @Override
    public void render(Graphics g) {}
}
