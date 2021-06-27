package livingObject;

import fsm.ImageRenderer;
import model.Direction;

import java.awt.*;

public class LivingObjectImageRenderer implements ImageRenderer {
    private LivingObject livingObject;

    public LivingObjectImageRenderer(LivingObject livingObject) {
        this.livingObject = livingObject;
    }

    @Override
    public void render(Image image, Graphics g) {
        // image should face LEFT
        Direction face = livingObject.getFace();
        Rectangle range = livingObject.getRange();
        Rectangle body = livingObject.getBody();
        if (face == Direction.LEFT) {
            g.drawImage(image, range.x, range.y, range.width, range.height, null);
        }
        else {
            g.drawImage(image, range.x + range.width, range.y, -range.width, range.height, null);
        }
        // for debug
        g.setColor(Color.RED);
        g.drawRect(body.x, body.y, body.width, body.height);
    }
}
