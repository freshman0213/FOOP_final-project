package livingObject;

import flyingObject.Bullet;
import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import livingObject.bullet.NormalBulletState;
import livingObject.cd.NormalCDState;
import livingObject.numBullets.NormalNumBulletsState;
import livingObject.velocity.NormalVelocityState;
import livingObject.velocity.VelocityState;
import model.Direction;
import model.HealthPointSprite;
import model.SpriteShape;
import warplane.Warplane;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static livingObject.LivingObject.Status.*;
import static livingObject.LivingObject.Event.*;
import static utils.ImageStateUtils.imagesToImagesStates;
import static fsm.FiniteStateMachine.Transition.from;
import static model.Direction.*;

public abstract class LivingObject extends HealthPointSprite {
    // Status
    private final Map<Object, StatusState> defaultStatus = new HashMap<>();
    protected final Map<Object, StatusState> currentStatus = new HashMap<>(); // for warplanes to display status
    // Shape
    private final SpriteShape shape;
    // Movement
    private final FiniteStateMachine fsm;
    private final Set<Direction> directions = new CopyOnWriteArraySet<>();

    public enum Status {
        CD, Bullet, NumBullets, Velocity
    }

    public enum Event {
        WALK, STOP
    }

    public LivingObject(int hp, int cd, Bullet bullet, int numBullet, int velocity, SpriteShape shape, List<Image> idleImages, List<Image> walkingImages) {
        super(hp);
        defaultStatus.put(CD, new NormalCDState(-1, this, cd, ));
        currentStatus.put(CD, defaultStatus.get(CD).copy());
        defaultStatus.put(Warplane.Status.Bullet, new NormalBulletState(-1, this, bullet, ));
        currentStatus.put(Warplane.Status.Bullet, defaultStatus.get(Warplane.Status.Bullet).copy());
        defaultStatus.put(NumBullets, new NormalNumBulletsState(-1, this, numBullet, ));
        currentStatus.put(NumBullets, defaultStatus.get(NumBullets).copy());
        defaultStatus.put(Velocity, new NormalVelocityState(-1, this, velocity, ));
        currentStatus.put(Velocity, defaultStatus.get(Velocity).copy());

        this.shape = shape;

        fsm = new FiniteStateMachine();
        ImageRenderer imageRenderer = new LivingObjectImageRenderer(this);
        State idle = new WaitingPerFrame(5,
                new Idle(imagesToImagesStates(idleImages, imageRenderer)));
        State walking = new WaitingPerFrame(5,
                new Walking(this, imagesToImagesStates(walkingImages, imageRenderer)));
        fsm.setInitialState(idle);
        fsm.addTransition(from(idle).when(WALK).to(walking));
        fsm.addTransition(from(walking).when(STOP).to(idle));
    }

    public int getVelocity() {
        return ((VelocityState) currentStatus.get(Velocity)).getVelocity();
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public void changeStatus(Object status, StatusState newState) {
        if (newState.getClass().equals(defaultStatus.get(status).getClass())) {

        }
    }

    public void reset(Object status) {
        currentStatus.put(status, defaultStatus.get(status).copy());
    }

    public void fire() {
        // TODO
    }

    public void move(Direction direction) {
        if (direction == LEFT || direction == RIGHT) {
            face = direction;
        }
        if (!directions.contains(direction)) {
            this.directions.add(direction);
            fsm.trigger(WALK);
        }
    }

    public void stop(Direction direction) {
        directions.remove(direction);
        if (directions.isEmpty()) {
            fsm.trigger(STOP);
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        fsm.render(g);
    }

    @Override
    public void update() {
        fsm.update();
        for (Object status : Status.values()) {
            currentStatus.get(status).update();
        }
    }

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