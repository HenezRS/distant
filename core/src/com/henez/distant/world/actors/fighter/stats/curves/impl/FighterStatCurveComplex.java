package com.henez.distant.world.actors.fighter.stats.curves.impl;

import com.henez.distant.enums.stats.BasicCurveStrength;
import com.henez.distant.world.actors.fighter.stats.curves.FighterStatCurve;

public class FighterStatCurveComplex implements FighterStatCurve {
    private float endCurve;
    private float endAdd;

    /*public int getMaxAtLevel(int level) {
        float base = 5;
        float baseCurved = base;
        float curve = 1.02f;
        float add = 1;

        float max = base;
        for (int i = 1; i < level; ++i) {
            baseCurved *= curve;
            max = baseCurved;
            max += add;

            curve *= 1.0004f;
            add *= 0.97f;
        }

        endCurve = curve;
        endAdd = add;
        return (int) max;
    }

    public String getMaxAtLevelFormatted(int level) {
        int max = getMaxAtLevel(level);
        return String.format("Lv %s: %s --- (add: %s) - (curve: %s)", level, max, endAdd, endCurve);
    }*/

    @Override public int getMaxAtLevel(BasicCurveStrength basicCurveStrength, int level, float multiplyOutcome) {
        return 0;
    }

    @Override public String getMaxAtLevelFormatted(BasicCurveStrength basicCurveStrength, int level, float multiplyOutcome) {
        return null;
    }
}
