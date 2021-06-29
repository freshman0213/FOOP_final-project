package model;

import healthpointbar.HealthPointBar;

import java.awt.*;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class HealthPointSprite extends Sprite {

    protected HealthPointBar hpBar;

    public HealthPointSprite(int hp) {
        this.hpBar = new HealthPointBar(hp);
        hpBar.setOwner(this);
    }

    public int getHP() {
        return hpBar.getHp();
    }

    @Override
    public void onHealed(int heal) {
        hpBar.onHealed(heal);
    }

    @Override
    public void onDamaged(Rectangle damageArea, int damage) {
        hpBar.onDamaged(damageArea, damage);
        if (hpBar.isDead()) {
            world.removeSprite(this);
        }
    }

    @Override
    public void render(Graphics g) {
        hpBar.render(g);
    }
}
