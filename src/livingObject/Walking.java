package livingObject;

import fsm.CyclicSequence;
import fsm.ImageState;
import model.Direction;

import java.util.List;

public class Walking extends CyclicSequence {
    public final LivingObject livingObject;

    public Walking(LivingObject livingObject, List<ImageState> states) {
        super(states);
        this.livingObject = livingObject;
    }

    @Override
    public void update() {
        if (livingObject.isAlive()) {
            super.update();
            for (Direction direction : livingObject.getDirections()) {
                livingObject.getWorld().move(livingObject, direction.translate(livingObject.getVelocity())); // TODO: need to take velocity into consideration
            }
        }
    }
}
