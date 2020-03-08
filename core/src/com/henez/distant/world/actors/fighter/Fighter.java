package com.henez.distant.world.actors.fighter;

import com.henez.distant.world.actors.Actor;
import com.henez.distant.world.actors.fighter.stats.FighterStats;
import com.henez.distant.world.animation.Sprite;

public class Fighter extends Actor {
    protected FighterStats stats;

    public Fighter(int gx, int gy, Sprite sprite) {
        super(gx, gy, sprite);
    }
}
