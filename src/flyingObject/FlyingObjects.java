package flyingObject;

import effect.Effect;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import model.Sprite;
import model.SpriteShape;

import java.util.List;
import java.awt.*;
import java.util.ArrayList;

import static utils.ImageStateUtils.imagesToImagesStates;

public abstract class FlyingObjects extends Sprite {
    private final SpriteShape shape;
    private Dimension movement;
    protected List<Effect> effects = new ArrayList<>();
    private final State imagesState;

    public FlyingObjects(SpriteShape shape, Dimension movement, List<Image> images) {
        this.shape = shape;
        this.movement = movement;

        ImageRenderer imageRenderer = new FlyingObjectImageRenderer(this);
        imagesState = new WaitingPerFrame(2,
                new Idle(imagesToImagesStates(images, imageRenderer)));
    }

    public List<Effect> getEffects() {
        return effects;
    }

    @Override
    public void update() {
        this.getWorld().move(this, movement);
    }

    @Override
    public void render(Graphics g) {
        imagesState.render(g);
    }

    @Override
    public void onDamaged(Rectangle damageArea, int damage) {}

    @Override
    public Rectangle getRange() {
        return new Rectangle(location, shape.size);
    }

    @Override
    public Dimension getBodyOffset() {
        return shape.bodyOffset;
    }

    @Override
    public Dimension getBodySize() {
        return shape.bodySize;
    }
}
