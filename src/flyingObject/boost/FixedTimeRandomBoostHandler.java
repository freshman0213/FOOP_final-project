package flyingObject.boost;

import flyingObject.Boost;
import utils.FixedRandom;
import views.GameView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixedTimeRandomBoostHandler implements BoostHandler {
    public static int LENGTH = 800;
    private int remaining;
    private List<Boost> candidateBoosts = Arrays.asList(new CDBoost(new Point(0, 0)));

    public FixedTimeRandomBoostHandler() {
        remaining = LENGTH;
    }

    @Override
    public List<Boost> getBoosts() {
        List<Boost> newBoosts = new ArrayList<>();
        if (-- remaining <= 0) {
            newBoosts.add(candidateBoosts.get(FixedRandom.nextInt(candidateBoosts.size())).copy(new Point(FixedRandom.nextInt(GameView.WIDTH), 100)));
            remaining = LENGTH;
        }
        return newBoosts;
    }
}
