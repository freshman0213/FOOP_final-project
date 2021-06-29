package flyingObject;

import flyingObject.boost.BoostImageRenderer;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesToImagesStates;

public abstract class Boost extends FlyingObjects {
    public static Dimension MOVEMENT = new Dimension(0, 5); // can only move downward
    private final State imagesState;

    public Boost(SpriteShape shape, List<Image> images) {
        super(shape, MOVEMENT, images);

        ImageRenderer imageRenderer = new BoostImageRenderer(this);
        imagesState = new WaitingPerFrame(3,
                new Idle(imagesToImagesStates(images, imageRenderer)));
    }

    public abstract Boost copy(Point location);

    @Override
    public void update() {
        super.update();
        imagesState.update();
    }

    public void render(Graphics g) {
        imagesState.render(g);
    }
}
