package livingObject.bulletMovement;

import livingObject.LivingObject;
import livingObject.StatusState;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NormalBulletsMovementState implements BulletMovementState {
    private int state_remaining;
    private final LivingObject livingObject;
    private final int numBullets;
    private final int direction; // up: -1, down: 1

    public NormalBulletsMovementState(int lasting_time, LivingObject livingObject, int numBullets, int direction) {
        this.state_remaining = lasting_time;
        this.livingObject = livingObject;
        this.numBullets = numBullets;
        this.direction = direction;
    }

    @Override
    public StatusState copy() {
        return new NormalBulletsMovementState(this.state_remaining, this.livingObject, this.numBullets, this.direction);
    }

    @Override
    public List<Dimension> getMovements() {
        // Symmetric
        List<Dimension> movements = new ArrayList<>();
        for (int i = 1; i <= numBullets / 2; i++) {
            movements.add(new Dimension(i, direction*5));
            movements.add(new Dimension(-i, direction*5));
        }
        if (numBullets % 2 == 1) {
            movements.add(new Dimension(0, direction*5));
        }
        return movements;
    }

    @Override
    public void update() {
        if (state_remaining > 0) {
            state_remaining --;
            if (state_remaining == 0) {
                livingObject.resetBulletMovement();
            }
        }
    }

    @Override
    public void render(Graphics g) {}
}
