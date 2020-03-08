package com.henez.distant.world.actors.fighter.stats.curves.impl;

import com.henez.distant.enums.stats.BasicCurveStrength;
import com.henez.distant.world.actors.fighter.stats.curves.FighterStatCurve;

public class FighterStatCurveXp implements FighterStatCurve {
    private float endAdd;
    private float endAddMul;

    @Override
    public int getMaxAtLevel(BasicCurveStrength basicCurveStrength, int level, float multiplyOutcome) {
        float base = basicCurveStrength.getBase();
        float add = basicCurveStrength.getAdd();

        float max = base;
        float addMul = 1.21f;
        float addLessMul = 0.9975f;
        for (int i = 1; i < level; ++i) {
            max += add;
            add *= addMul;
            addMul *= addLessMul;
        }
        endAdd = add;
        endAddMul = addMul;
        return (int) (max * multiplyOutcome);
    }

    @Override
    public String getMaxAtLevelFormatted(BasicCurveStrength basicCurveStrength, int level, float multiplyOutcome) {
        int max = getMaxAtLevel(basicCurveStrength, level, multiplyOutcome);
        return String.format("[%s] - Lv %s: %s --- (add: %.2f [%.2f]) --- (mul: %s)", basicCurveStrength.getName(), level, max, endAdd, endAddMul, multiplyOutcome);
    }
}
