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
        // image should face UP
        Dimension movement = flyingObjects.getMovement();
        Rectangle range = flyingObjects.getRange();
        Rectangle body = flyingObjects.getBody();
        if (movement.height < 0) {
            g.drawImage(image, range.x, range.y, range.width, range.height, null);
        }
        else {
            g.drawImage(image, range.x, range.y + range.height, range.width, -range.height, null);
        }
        // for debug
        g.setColor(Color.BLUE);
        g.drawRect(body.x, body.y, body.width, body.height);
    }
}
