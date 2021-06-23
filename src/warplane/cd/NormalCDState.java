package warplane.cd;

import fsm.ImageRenderer;
import warplane.StatusState;
import warplane.Warplane;

import java.awt.*;

import static warplane.Warplane.Status.*;

public class NormalCDState implements StatusState {
    private int state_remaining;
    private final Warplane warplane;
    private final int cd;
    private int cd_remaining;
    private final Image image;
    private final ImageRenderer imageRenderer;

    public NormalCDState(int lasting_time, Warplane warplane, int cd, Image image, ImageRenderer imageRenderer) {
        this.state_remaining = lasting_time;
        this.warplane = warplane;
        this.cd_remaining = this.cd = cd;
        this.image = image;
        this.imageRenderer = imageRenderer;
    }

    @Override
    public StatusState copy() {
        return new NormalCDState(this.state_remaining, this.warplane, this.cd, this.image, this.imageRenderer);
    }

    @Override
    public void update() {
        if (--cd_remaining <= 0) {
            warplane.fire();
            cd_remaining = cd;
        }
        if (state_remaining > 0) { // prevent overflow
            state_remaining --;
            if (state_remaining == 0) {
                warplane.reset(CD);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        imageRenderer.render(image, g);
    }
}
