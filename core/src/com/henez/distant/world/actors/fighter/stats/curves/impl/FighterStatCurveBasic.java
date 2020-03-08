package com.henez.distant.world.actors.fighter.stats.curves.impl;

import com.henez.distant.enums.stats.BasicCurveStrength;
import com.henez.distant.world.actors.fighter.stats.curves.FighterStatCurve;

public class FighterStatCurveBasic implements FighterStatCurve {
    private float endAdd;

    @Override
    public int getMaxAtLevel(BasicCurveStrength basicCurveStrength, int level, float multiplyOutcome) {
        float base = basicCurveStrength.getBase();
        float add = basicCurveStrength.getAdd();

        float max = base;
        for (int i = 1; i < level; ++i) {
            max += add;
            add *= 1.006f;
        }
        endAdd = add;
        return (int) (max * multiplyOutcome);
    }

    @Override
    public String getMaxAtLevelFormatted(BasicCurveStrength basicCurveStrength, int level, float multiplyOutcome) {
        int max = getMaxAtLevel(basicCurveStrength, level, multiplyOutcome);
        return String.format("[%s] - Lv %s: %s --- (add: %.2f) --- (mul: %s)", basicCurveStrength.getName(), level, max, endAdd, multiplyOutcome);
    }
}
