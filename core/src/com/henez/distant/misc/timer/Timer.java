package com.henez.distant.misc.timer;

public class Timer {
    protected int tick;
    protected int delay;
    protected boolean done;

    public Timer(int delay) {
        this.delay = delay;
        reset();
    }

    public void reset() {
        tick = 0;
        done = false;
    }

    public boolean update() {
        if (!done) {
            tick++;
            done = tick >= delay;
        }
        return done;
    }
}
