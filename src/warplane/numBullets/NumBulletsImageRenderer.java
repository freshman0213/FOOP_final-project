package warplane.numBullets;

import fsm.ImageRenderer;
import model.Direction;
import warplane.Warplane;

import java.awt.*;

public class NumBulletsImageRenderer implements ImageRenderer {
    protected Warplane warplane;

    public NumBulletsImageRenderer(Warplane warplane) {
        this.warplane = warplane;
    }

    @Override
    public void render(Image image, Graphics g) {

    }
}
