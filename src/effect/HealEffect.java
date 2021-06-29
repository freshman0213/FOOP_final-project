package effect;

import livingObject.LivingObject;

public class HealEffect implements Effect {
    private int heal;

    public HealEffect(int heal) {
        this.heal = heal;
    }

    @Override
    public void apply(LivingObject livingObject) {
        livingObject.onHealed(heal);
    }
}
