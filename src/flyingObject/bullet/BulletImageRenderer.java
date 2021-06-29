package flyingObject.bullet;

import flyingObject.Bullet;
import fsm.ImageRenderer;

import java.awt.*;

public class BulletImageRenderer implements ImageRenderer {
    private Bullet bullet;

    public BulletImageRenderer(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void render(Image image, Graphics g) {
        // image should face UP
        Dimension movement = bullet.getMovement();
        Rectangle range = bullet.getRange();
        Rectangle body = bullet.getBody();
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
