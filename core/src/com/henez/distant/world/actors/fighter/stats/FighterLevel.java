package com.henez.distant.world.actors.fighter.stats;

import com.henez.distant.enums.stats.BasicCurveStrength;
import com.henez.distant.world.actors.fighter.stats.curves.FighterStatCurve;
import com.henez.distant.world.actors.fighter.stats.curves.impl.FighterStatCurveXp;

public class FighterLevel {
    private int level;
    private int xp;
    private int xpNext;
    FighterStatCurve curve;

    public FighterLevel() {
        curve = new FighterStatCurveXp();
        xp = 0;
        setLevel(1);
    }

    private void setLevel(int level) {
        this.level = level;
        calcNext();
    }

    private void calcNext() {
        xpNext = curve.getMaxAtLevel(BasicCurveStrength.XP, level, 1);
    }
}
