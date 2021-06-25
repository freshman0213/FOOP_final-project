package livingObject;

import flyingObject.Bullet;
import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import livingObject.bullet.BulletState;
import livingObject.bullet.NormalBulletState;
import livingObject.bulletMovement.BulletMovementState;
import livingObject.cd.NormalCDState;
import livingObject.bulletMovement.NormalBulletsMovementState;
import livingObject.velocity.NormalVelocityState;
import livingObject.velocity.VelocityState;
import model.Direction;
import model.HealthPointSprite;
import model.SpriteShape;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static livingObject.LivingObject.Event.*;
import static utils.ImageStateUtils.imagesToImagesStates;
import static fsm.FiniteStateMachine.Transition.from;
import static model.Direction.*;

public abstract class LivingObject extends HealthPointSprite {
    // Status
    private final StatusState default_cd;
    private final BulletState default_bullet;
    private final BulletMovementState default_bulletMovement;
    private final VelocityState default_velocity;
    protected StatusState current_cd;
    protected BulletState current_bullet;
    protected BulletMovementState current_bulletMovement;
    protected VelocityState current_velocity;
    // Shape
    private final SpriteShape shape;
    // Movement
    private final FiniteStateMachine fsm;
    private final Set<Direction> directions = new CopyOnWriteArraySet<>();

    public enum Event {
        WALK, STOP
    }

    public LivingObject(int hp, int cd, Bullet bullet, int numBullet, int direction, int velocity, SpriteShape shape, List<Image> idleImages, List<Image> walkingImages) {
        super(hp);
        default_cd = new NormalCDState(-1, this, cd);
        current_cd = default_cd.copy();
        default_bullet = new NormalBulletState(-1, this, bullet);
        current_bullet = (BulletState) default_bullet.copy();
        default_bulletMovement = new NormalBulletsMovementState(-1, this, numBullet, direction);
        current_bulletMovement = (BulletMovementState) default_bulletMovement.copy();
        default_velocity = new NormalVelocityState(-1, this, velocity);
        current_velocity = (VelocityState) default_velocity.copy();

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
        return current_velocity.getVelocity();
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public void changeCD(StatusState newState) {
        current_cd = newState;
    }

    public void resetCD() {
        current_cd = default_cd.copy();
    }

    public void changeBullet(BulletState newState) {
        current_bullet = newState;
    }

    public void resetBullet() {
        current_bullet = (BulletState) default_bullet.copy();
    }

    public void changeBulletMovement(BulletMovementState newState) {
        current_bulletMovement = newState;
    }

    public void resetBulletMovement() {
        current_bulletMovement = (BulletMovementState) default_bulletMovement.copy();
    }

    public void changeVelocity(VelocityState newState) {
        current_velocity = newState;
    }

    public void resetVelocity() {
        current_velocity = (VelocityState) default_velocity.copy();
    }

    public abstract void fire(); // each living object shoot bullets from different places

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
        current_cd.update();
        current_bullet.update();
        current_bulletMovement.update();
        current_velocity.update();
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