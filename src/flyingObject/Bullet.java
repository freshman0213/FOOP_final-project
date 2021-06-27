package flyingObject;

import effect.DamageEffect;
import model.SpriteShape;

import java.util.List;
import java.awt.*;

public abstract class Bullet extends FlyingObjects {
    private int damgge;
    protected List<Image> images; // for displaying current images

    public Bullet(SpriteShape shape, Dimension movement, List<Image> images, int damage) {
        super(shape, movement, images);
        this.images = images;
        this.effects.add(new DamageEffect(damage));
    }

    public List<Image> getImages() {
        return images;
    }
    public abstract Bullet copy(Dimension movement, Point location);

    @Override
    public Dimension getBodyOffset() {
        // bullets would move upward or downward, making the offset not consistent
        if (getMovement().height < 0) {
            return super.getBodyOffset();
        }
        else {
            Rectangle range = super.getRange();
            Dimension offset = super.getBodyOffset();
            Dimension body = super.getBodySize();
            return new Dimension(offset.width, range.height - body.height - offset.height);
        }
    }
}
