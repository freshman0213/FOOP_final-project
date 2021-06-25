package utils;

import java.util.Random;

public final class FixedRandom {
    private static final long SEED = 2021L;
    private static final Random random = new Random(2021L);

    FixedRandom() {
    }

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }
}
