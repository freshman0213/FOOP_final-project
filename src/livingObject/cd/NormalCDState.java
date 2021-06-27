package livingObject.cd;

import livingObject.LivingObject;
import livingObject.StatusState;

import java.awt.*;

import static utils.ImageStateUtils.imagesFromFolder;

public class NormalCDState implements StatusState {
    private int state_remaining;
    private final LivingObject livingObject;
    private final int cd;
    private int cd_remaining;
    private final Image image;

    public NormalCDState(int lasting_time, LivingObject livingObject, int cd) {
        this.state_remaining = lasting_time;
        this.livingObject = livingObject;
        this.cd_remaining = this.cd = cd;
        this.image = imagesFromFolder("").get(0);
    }

    @Override
    public StatusState copy() {
        return new NormalCDState(this.state_remaining, this.livingObject, this.cd);
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public void update() {
        if (--cd_remaining <= 0) {
            livingObject.fire();
            cd_remaining = cd;
        }
        if (state_remaining > 0) { // prevent overflow
            state_remaining --;
            if (state_remaining == 0) {
                livingObject.resetCD();
            }
        }
    }

    @Override
    public void render(Graphics g) {}
}