package ai;

import controller.Game;
import livingObject.LivingObject;
import model.Direction;
import utils.FixedRandom;

import java.util.Arrays;
import java.util.List;

import static model.Direction.*;

public class RandomBoss implements MoveAI {
    private final Game game;
    private final LivingObject owner;
    private int prev;
    public static List<Direction> directions = Arrays.asList(null, LEFT, RIGHT);

    public RandomBoss(Game game, LivingObject owner) {
        this.game = game;
        this.owner = owner;
        prev = 0;
    }

    @Override
    public void move() {
        while (owner.isAlive()) {
            // tends to move consistently
            int random = FixedRandom.nextInt(10);
            int now;
            if (random < 6) {
                now = prev;
            }
            else if (random < 8) {
                now = (prev + 1) % directions.size();
            }
            else {
                now = (prev + 2) % directions.size();
            }

            if (now != prev && prev != 0) {
                game.stop(, directions.get(prev));
            }
            if (now != 0) {
                game.move(, directions.get(now));
            }
            prev = now;
            delay(15);
        }
    }

    private void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}