package warplane.cd;

import fsm.ImageRenderer;
import warplane.Warplane;

import java.awt.*;

public class CDImageRenderer implements ImageRenderer {
    protected Warplane warplane;

    public CDImageRenderer(Warplane warplane) {
        this.warplane = warplane;
    }

    @Override
    public void render(Image image, Graphics g) {

    }
}
