package effect;

import livingObject.LivingObject;
import livingObject.velocity.NormalVelocityState;
import livingObject.velocity.VelocityState;

public class VelocityEffect implements Effect {
    private int velocity;
    private int length;

    public VelocityEffect(int velocity, int length) {
        this.velocity = velocity;
        this.length = length;
    }

    @Override
    public void apply(LivingObject livingObject) {
        livingObject.changeVelocity(new NormalVelocityState(length, livingObject, velocity));
    }
}
