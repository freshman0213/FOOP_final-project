package warplane.singlebomber;

import fsm.FiniteStateMachine;
import fsm.ImageRenderer;
import fsm.State;
import fsm.WaitingPerFrame;
import model.Direction;
import model.HealthPointSprite;
import model.SpriteShape;
import warplane.Warplane;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static fsm.FiniteStateMachine.Transition.from;
import static warplane.Warplane.EventStatus.*;
import static warplane.Warplane.EventPose.*;
import static utils.ImageStateUtils.imageStatesFromFolder;

public class SingleBomber extends Warplane {
    public static int HP = 100;
    public static int ATTACK_CD = 5;

    public SingleBomber(Point location) {
        this.location = location;
        shape = new SpriteShape(); // TODO : define this
        ImageRenderer imageRenderer = new SingleBomberImageRenderer(this);
        State idle = ;
        State walking = ;

        super(HP, ATTACK_CD, imageRenderer, idle, walking);
    }
}
