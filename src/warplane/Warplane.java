package warplane;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import model.Direction;
import model.HealthPointSprite;
import model.SpriteShape;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static fsm.FiniteStateMachine.Transition.from;
import static warplane.Warplane.EventStatus.*;
import static warplane.Warplane.EventPose.*;
import static utils.ImageStateUtils.imageStatesFromFolder;

public abstract class Warplane extends HealthPointSprite {
    protected SpriteShape shape;
    private final FiniteStateMachine fsmStatus, fsmPose;
    private final Set<Direction> directions = new CopyOnWriteArraySet<>();

    public enum EventStatus {
        Buff, Debuff
    }
    public enum EventPose {
        WALK, STOP
    }

    public Warplane(int hp, int attack_cd, ImageRenderer imageRenderer, State idle, State walking) { // template for all warplanes
        super(hp);
        fsmStatus = new FiniteStateMachine();
        fsmPose = new FiniteStateMachine();

        // State for Status (fixed for all warplanes)
        State normal = new WaitingPerFrame(,
                new ); // Wait several frames for each image
        State buffed = ;
        State debuffed = ;

        fsmStatus.setInitialState(normal);
        fsmStatus.addTransition(from(normal).when(Buff).to(buffed));
        fsmStatus.addTransition(from(normal).when(Debuff).to(debuffed));
        fsmStatus.addTransition(from(buffed).when(Buff).to(buffed)); // for multiple effects
        fsmStatus.addTransition(from(buffed).when(Debuff).to(debuffed));
        fsmStatus.addTransition(from(debuffed).when(Buff).to(buffed));
        fsmStatus.addTransition(from(debuffed).when(Debuff).to(debuffed));

        // State for Pose
        fsmPose.setInitialState(idle);
        fsmPose.addTransition(from(idle).when(WALK).to(walking));
        fsmPose.addTransition(from(walking).when(STOP).to(idle));
    }

    public void buff() {} // TODO : come up with a proper input to know which buff is taken

    public void move(Direction direction) {

    }

    public void stop(Direction direction) {

    }

    public void update() {
        // update position

        // shoot bullets (delegate to status)

    }

    @Override
    public void render(Graphics g) {

    }

    public Set<Direction> getDirections() {
        return directions;
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
