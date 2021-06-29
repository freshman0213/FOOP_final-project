package flyingObject.boost;

import flyingObject.Boost;
import fsm.ImageRenderer;

import java.awt.*;

public class BoostImageRenderer implements ImageRenderer {
    private Boost boost;

    public BoostImageRenderer(Boost boost) {
        this.boost = boost;
    }

    @Override
    public void render(Image image, Graphics g) {
        // image should face UP
        Rectangle range = boost.getRange();
        Rectangle body = boost.getBody();
        g.drawImage(image, range.x, range.y, range.width, range.height, null);
        // for debug
        g.setColor(Color.BLUE);
        g.drawRect(body.x, body.y, body.width, body.height);
    }
}
