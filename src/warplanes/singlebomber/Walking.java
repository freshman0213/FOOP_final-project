package warplanes.singlebomber;

import fsm.CyclicSequence;
import fsm.ImageState;
import model.Direction;

import java.util.List;

public class Walking extends CyclicSequence {
    public final SingleBomber singleBomber;

    public Walking(SingleBomber singleBomber, List<ImageState> states) {
        super(states);
        this.singleBomber = singleBomber;
    }

    @Override
    public void update() {
        if (singleBomber.isAlive()) {
            super.update();
            for (Direction direction : singleBomber.getDirections()) {
                singleBomber.getWorld().move(singleBomber, direction.translate(singleBomber.getVelocity()); // TODO: need to take velocity into consideration
            }
        }
    }
}
