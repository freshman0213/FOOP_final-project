package effect;

import livingObject.LivingObject;

public class HealEffect implements Effect {
    private int hp;

    public HealEffect(int hp) {
        this.hp = hp;
    }

    @Override
    public void apply(LivingObject livingObject) {
        livingObject.setHP(livingObject.getHP() + hp);
    }
}
