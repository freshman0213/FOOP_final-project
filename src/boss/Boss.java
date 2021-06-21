package boss;

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

import static utils.ImageStateUtils.imageStatesFromFolder;

public abstract class Boss extends HealthPointSprite { // template for all bosses
    protected SpriteShape shape;
    private final FiniteStateMachine fsmStatus, fsmPose;
    private final Direction direction;

    public Boss() {

    }

    public void update() {
        // control the state transition (trigger)
        // 1. angry -> buffed
        // 2. randomness in walking behaviors

    }

    @Override
    public void render(Graphics g) {

    }

    public Direction getDirection() {
        return direction;
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
