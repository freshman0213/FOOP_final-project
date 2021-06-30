package boostHandler;

import flyingObject.Boost;
import flyingObject.boost.*;
import utils.FixedRandom;
import views.GameView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixedTimeRandomBoostHandler implements BoostHandler {
    public static int LENGTH = 500;
    private int remaining;
    private List<Boost> candidateBoosts = Arrays.asList(new CDBoost(new Point(0, 0)),
            new HealBoost(new Point(0, 0)),
            new NumBulletBoost(new Point(0, 0)),
            new VelocityBoost(new Point(0, 0)),
            new BulletBoost(new Point(0, 0)));

    public FixedTimeRandomBoostHandler() {
        remaining = LENGTH;
    }

    @Override
    public List<Boost> getBoosts() {
        List<Boost> newBoosts = new ArrayList<>();
        if (-- remaining <= 0) {
            newBoosts.add(candidateBoosts.get(FixedRandom.nextInt(candidateBoosts.size())).copy(new Point(FixedRandom.nextInt(GameView.WIDTH), 300)));
            remaining = LENGTH;
        }
        return newBoosts;
    }
}
