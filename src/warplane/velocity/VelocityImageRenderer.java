package warplane.velocity;

import fsm.ImageRenderer;
import model.Direction;
import warplane.Warplane;

import java.awt.*;

public class VelocityImageRenderer implements ImageRenderer {
    protected Warplane warplane;

    public VelocityImageRenderer(Warplane warplane) {
        this.warplane = warplane;
    }

    @Override
    public void render(Image image, Graphics g) {

    }
}
