package fsm;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public interface StateMachine extends State {
    String EVENT_UPDATE = "update";

    @Override
    default void render(Graphics g) {
        currentState().render(g);
    }

    void trigger(Object event);

    State currentState();

    void reset();
}
