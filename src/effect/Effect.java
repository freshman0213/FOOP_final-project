package effect;

import warplane.StatusState;

import java.util.List;

public interface Effect {
    List<Object> getAffectedStatus();
    StatusState nextState(Object status);
}
