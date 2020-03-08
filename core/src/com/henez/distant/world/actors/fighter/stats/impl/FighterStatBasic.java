package com.henez.distant.world.actors.fighter.stats.impl;

import com.henez.distant.enums.stats.BasicCurveStrength;
import com.henez.distant.enums.stats.Stat;
import com.henez.distant.world.actors.fighter.stats.curves.FighterStatCurve;
import com.henez.distant.world.actors.fighter.stats.curves.impl.FighterStatCurveBasic;

public class FighterStatBasic {
    protected Stat stat;
    protected FighterStatCurve curve;
    protected BasicCurveStrength basicCurveStrength;
    protected int max;
    protected float current;

    public FighterStatBasic(Stat stat, BasicCurveStrength basicCurveStrength) {
        this.stat = stat;
        this.basicCurveStrength = basicCurveStrength;
        curve = new FighterStatCurveBasic();
        reset();
    }

    public void setMaxFromLevel(int level) {
        max = curve.getMaxAtLevel(basicCurveStrength, level, stat.getMul());
    }

    public void recoverFlat(float amount) {
        current += amount;
    }

    public void recoverPercent(float amount) {
        current += max * amount;
    }

    public void reset() {
        current = max;
    }

    public void resetBattleStart() {
    }
}
