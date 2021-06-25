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
}
