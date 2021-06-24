package flyingObject;

import fsm.ImageRenderer;

import java.awt.*;

public class FlyingObjectImageRenderer implements ImageRenderer {
    private FlyingObjects flyingObjects;

    public FlyingObjectImageRenderer(FlyingObjects flyingObjects) {
        this.flyingObjects = flyingObjects;
    }

    @Override
    public void render(Image image, Graphics g) {
        // TODO
    }
}
