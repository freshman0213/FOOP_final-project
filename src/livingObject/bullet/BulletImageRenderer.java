package livingObject.bullet;

import fsm.ImageRenderer;
import warplane.Warplane;

import java.awt.*;

public class BulletImageRenderer implements ImageRenderer {
    protected Warplane warplane;

    public BulletImageRenderer(Warplane warplane) {
        this.warplane = warplane;
    }

    @Override
    public void render(Image image, Graphics g) {

    }
}
