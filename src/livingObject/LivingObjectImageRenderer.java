package livingObject;

import fsm.ImageRenderer;

import java.awt.*;

public class LivingObjectImageRenderer implements ImageRenderer {
    private LivingObject livingObject;

    public LivingObjectImageRenderer(LivingObject livingObject) {
        this.livingObject = livingObject;
    }

    @Override
    public void render(Image image, Graphics g) {
        // TODO
    }
}
