package livingObject.bulletMovement;

import livingObject.StatusState;

import java.awt.*;
import java.util.List;

public interface BulletMovementState extends StatusState {
    List<Dimension> getMovements();
}
