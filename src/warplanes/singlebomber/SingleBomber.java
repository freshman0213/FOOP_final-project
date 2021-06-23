package warplanes.singlebomber;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.WaitingPerFrame;
import fsm.State;
import model.Direction;
import model.SpriteShape;
import warplane.Warplane;
import flyingObjects.Bullet;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static fsm.FiniteStateMachine.Transition.from;
import static warplanes.singlebomber.SingleBomber.Event.*;
import static utils.ImageStateUtils.imageStatesFromFolder;
import static model.Direction.*;

public class SingleBomber extends Warplane {
    public static final int HP = 100;
    public static final int CD = 5;
    public static final Bullet BULLET = new ;
    public static final int NUMBULLET = 1;
    public static final int VELOCITY = 5;
    private FiniteStateMachine fsm;
    private final Set<Direction> directions = new CopyOnWriteArraySet<>();

    public enum Event {
        WALK, STOP
    }

    public SingleBomber(Point location) {
        super(HP, CD, BULLET, NUMBULLET, VELOCITY);
        this.location = location;
        this.shape = new SpriteShape(new Dimension(), new Dimension(), new Dimension());
        this.fsm = new FiniteStateMachine();

        ImageRenderer imageRenderer = new SingleBomberImageRenderer(this);
        State idle = new WaitingPerFrame(5,
                new Idle(imageStatesFromFolder(, imageRenderer)));
        State walking = new WaitingPerFrame(5,
                new Walking(this, imageStatesFromFolder(, imageRenderer)));

        fsm.setInitialState(idle);
        fsm.addTransition(from(idle).when(WALK).to(walking));
        fsm.addTransition(from(walking).when(STOP).to(idle));
    }

    @Override
    public void fire() {
        // TODO: finish this after finish Bullet
        // TODO: every type of warplane has its own position to fire the bullets
    }

    @Override
    public void move(Direction direction) {
        if (direction == LEFT || direction == RIGHT) {
            face = direction;
        }
        if (!directions.contains(direction)) {
            this.directions.add(direction);
            fsm.trigger(WALK);
        }
    }

    @Override
    public void stop(Direction direction) {
        directions.remove(direction);
        if (directions.isEmpty()) {
            fsm.trigger(STOP);
        }
    }

    @Override
    public void update() {
        fsm.update();
        super.update();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        fsm.render(g);
    }

    public Set<Direction> getDirections() {
        return directions;
    }

}
