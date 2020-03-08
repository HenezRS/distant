package com.henez.distant.world.actors.fighter.stats.curves;

import com.henez.distant.enums.stats.BasicCurveStrength;

public interface FighterStatCurve {

    int getMaxAtLevel(BasicCurveStrength basicCurveStrength, int level, float multiplyOutcome);

    String getMaxAtLevelFormatted(BasicCurveStrength basicCurveStrength, int level, float multiplyOutcome);
}
