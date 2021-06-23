package warplane;

import fsm.ImageRenderer;
import model.Direction;
import model.HealthPointSprite;
import model.SpriteShape;
import flyingObjects.Bullet;
import warplane.cd.*;
import warplane.bullet.*;
import warplane.numBullets.*;
import warplane.velocity.*;
import effect.Effect;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static warplane.Warplane.Status.*;

public abstract class Warplane extends HealthPointSprite {
    protected SpriteShape shape;
    private final Map<Object, ImageRenderer> imageRenderers = new HashMap<>();
    private final Map<Object, StatusState> defaultStatus = new HashMap<>();
    private final Map<Object, StatusState> currentStatus = new HashMap<>();

    public enum Status {
        CD, Bullet, NumBullets, Velocity
    }

    public Warplane(int hp, int cd, Bullet bullet, int numBullet, int velocity) { // template for all warplanes
        super(hp);
        imageRenderers.put(CD, new CDImageRenderer(this));
        imageRenderers.put(Bullet, new BulletImageRenderer(this));
        imageRenderers.put(NumBullets, new NumBulletsImageRenderer(this));
        imageRenderers.put(Velocity, new VelocityImageRenderer(this));

        // TODO: 1. how to present the status (what image should we use)
        defaultStatus.put(CD, new NormalCDState(-1, this, cd, , imageRenderers.get(CD)));
        currentStatus.put(CD, defaultStatus.get(CD).copy());
        defaultStatus.put(Bullet, new NormalBulletState(-1, this, bullet, , imageRenderers.get(Bullet)));
        currentStatus.put(Bullet, defaultStatus.get(Bullet).copy());
        defaultStatus.put(NumBullets, new NormalNumBulletsState(-1, this, numBullet, , imageRenderers.get(NumBullets)));
        currentStatus.put(NumBullets, defaultStatus.get(NumBullets).copy());
        defaultStatus.put(Velocity, new NormalVelocityState(-1, this, velocity, , imageRenderers.get(Velocity)));
        currentStatus.put(Velocity, defaultStatus.get(Velocity).copy());
    }

    public int getVelocity() {
        return ((VelocityState) currentStatus.get(Velocity)).getVelocity();
    }

    public ImageRenderer getImageRenderer(Object status) {
        return imageRenderers.get(status);
    }

    public void takeEffect(Effect effect) {
        List<Object> affectedStatus = effect.getAffectedStatus();
        for (Object status : affectedStatus) {
            currentStatus.put(status, effect.nextState(status));
        }
    }

    public void reset(Object status) {
        currentStatus.put(status, defaultStatus.get(status).copy());
    }

    public abstract void fire();

    public abstract void move(Direction direction);

    public abstract void stop(Direction direction);

    public void update() { // shoot bullets
        for (Status status : Status.values()) {
            currentStatus.get(status).update();
        }
    }

    @Override
    public void render(Graphics g) { // render the status
        for (Status status : Status.values()) {
            currentStatus.get(status).render(g);
        }
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public Rectangle getRange() {
        return new Rectangle(location, shape.size);
    } // size of the image

    @Override
    public Dimension getBodyOffset() {
        return shape.bodyOffset;
    } // from top left cornet of the iamge to the top left corner of the rigid body

    @Override
    public Dimension getBodySize() {
        return shape.bodySize;
    } // size of the rigid body


}
