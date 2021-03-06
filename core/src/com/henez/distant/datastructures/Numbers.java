package com.henez.distant.datastructures;

import java.util.Random;

public class Numbers {

    public static Random random = new Random(255);

    private Numbers() {

    }

    /**
     * Returns {@code int} value between min and max inclusive of both bounds.
     */
    public static int nextIntBetween(int min, int max) {
        return min + random.nextInt((max + 1) - min);
    }

    public static float nextFloatBetween(float min, float max) {
        return (min + ((random.nextFloat() + 0.0001f) * (max - min)));
    }

    public static boolean flip() {
        return random.nextInt(1) == 1;
    }

    public static float floor(float in) {
        int v = (int) in;
        return (float) v;
    }

    public static int clamp(int value, int min, int max) {
        int v = value > max ? max : value;
        return v < min ? min : v;
    }

    public static int round(float value) {
        return Math.round(value);
    }
}
