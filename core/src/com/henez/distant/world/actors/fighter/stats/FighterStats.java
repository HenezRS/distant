package com.henez.distant.world.actors.fighter.stats;

import com.henez.distant.enums.stats.BasicCurveStrength;
import com.henez.distant.enums.stats.Stat;
import com.henez.distant.world.actors.fighter.stats.impl.FighterStatBasic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FighterStats {
    Map<Stat, FighterStatBasic> stats;
    FighterLevel fighterLevel;

    public FighterStats() {
        fighterLevel = new FighterLevel();
        createAndDefaultStats();
    }

    private void createAndDefaultStats() {
        stats = new HashMap<>();
        Arrays.stream(Stat.values()).forEach(stat -> createStatBasic(stat, BasicCurveStrength.getRandom()));
    }

    private void createStatBasic(Stat stat, BasicCurveStrength curve) {
        stats.put(stat, new FighterStatBasic(stat, curve));
    }
}
