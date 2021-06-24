package flyingObject;

import fsm.CyclicSequence;
import fsm.ImageState;

import java.util.List;

public class Idle extends CyclicSequence {
    public Idle(List<ImageState> states) {
        super(states);
    }
}
