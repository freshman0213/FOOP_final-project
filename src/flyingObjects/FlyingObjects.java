package flyingObjects;

import fsm.ImageState;
import model.Sprite;
import model.SpriteShape;

import java.awt.*;

public class FlyingObjects extends Sprite { // templates for bullets, boosts
    private SpriteShape shape;
    private Image image; // no renderer needed because only one image
    private Dimension velocity;

    public FlyingObjects() {

    }

    public Image getImage() {
        return image;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

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
