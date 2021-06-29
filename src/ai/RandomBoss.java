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
    private int length, remaining;
    public static List<Direction> directions = Arrays.asList(null, LEFT, RIGHT);

    public RandomBoss(Game game, LivingObject owner) {
        this.game = game;
        this.owner = owner;
        prev = 0;
        length = remaining = 10;
        new Thread(this::move).start();
    }

    @Override
    public void move() {
        while (owner.isAlive()) {
            // tends to move consistently
            int now;
            if (-- remaining <= 0) {
                int random = FixedRandom.nextInt(10);
                if (random < 8) {
                    now = prev;
                }
                else if (random < 9) {
                    now = (prev + 1) % directions.size();
                }
                else {
                    now = (prev + 2) % directions.size();
                }
                remaining = length;
            }
            else {
                now = prev;
            }

            if (now != prev && prev != 0) {
                game.stopBoss(directions.get(prev));
            }
            if (now != 0) {
                game.moveBoss(directions.get(now));
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
