package flyingobjects;

import model.Sprite;
import model.SpriteShape;
import effect.Effect;

import java.awt.*;

public abstract class FlyingObjects extends Sprite { // templates for bullets, boosts
    protected SpriteShape shape;
    protected Dimension VELOCITY;
    protected Effect effects;

    @Override
    public void update() {

    }

    @Override
    public void onDamaged(Rectangle damageArea, int damage) {

    }

    @Override
    public Rectangle getRange() {
        return null;
    }

    @Override
    public Dimension getBodyOffset() {
        return null;
    }

    @Override
    public Dimension getBodySize() {
        return null;
    }


}
