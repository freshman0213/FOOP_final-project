package effect;

import livingObject.LivingObject;

import java.awt.*;

public class DamageEffect implements Effect {
    private int damage;

    public DamageEffect(int damage) {
        this.damage = damage;
    }

    @Override
    public void apply(LivingObject livingObject) {
        livingObject.onDamaged(null, damage);
    } // don't care damageArea
}
