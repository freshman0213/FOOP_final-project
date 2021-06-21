package warplane.singlebomber;

import fsm.ImageRenderer;
import model.Direction;

import java.awt.*;

public class SingleBomberImageRenderer implements ImageRenderer {
    protected SingleBomber singleBomber;

    public SingleBomberImageRenderer(SingleBomber singleBomber) {
        this.singleBomber = singleBomber;
    }

    @Override
    public void render(Image image, Graphics g) {

    }

}
