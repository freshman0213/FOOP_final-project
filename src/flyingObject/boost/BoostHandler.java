package flyingObject.boost;

import flyingObject.Boost;

import java.util.List;

public interface BoostHandler {
    // decide when to drop a boost
    List<Boost> getBoosts();
}
