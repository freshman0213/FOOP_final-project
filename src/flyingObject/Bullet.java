package flyingObject;

import effect.DamageEffect;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

import static utils.ImageStateUtils.imagesToImagesStates;

public abstract class Bullet extends FlyingObjects {
    private int damage;
    private final State imagesState;
    private final Image imageForBoost;

    public Bullet(SpriteShape shape, Dimension movement, List<Image> images, int damage) {
        super(shape, movement, images);
        this.damage = damage;
        this.effects.add(new DamageEffect(damage));
        imageForBoost = images.get(0);

        ImageRenderer imageRenderer = new BulletImageRenderer(this);
        imagesState = new WaitingPerFrame(3,
                new Idle(imagesToImagesStates(images, imageRenderer)));
    }

    public Image getImage() {
        return imageForBoost;
    }

    public abstract Bullet copy(Dimension movement, Point location);

    @Override
    public void update() {
        super.update();
        imagesState.update();
    }

    public void render(Graphics g) {
        imagesState.render(g);
    }

    @Override
    public Dimension getBodyOffset() {
        // bullets would move upward or downward, making the offset not consistent
        if (getMovement().height < 0) {
            Dimension offset = super.getBodyOffset();
            return offset;
        }
        else {
            Rectangle range = super.getRange();
            Dimension offset = super.getBodyOffset();
            Dimension body = super.getBodySize();
            return new Dimension(offset.width, range.height - body.height - offset.height);
        }
    }
}
