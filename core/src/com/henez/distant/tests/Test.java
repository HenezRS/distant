package com.henez.distant.tests;

import com.henez.distant.enums.stats.BasicCurveStrength;
import com.henez.distant.world.actors.fighter.stats.curves.FighterStatCurve;
import com.henez.distant.world.actors.fighter.stats.curves.impl.FighterStatCurveXp;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        FighterStatCurve curve = new FighterStatCurveXp();

        Arrays.stream(BasicCurveStrength.values()).forEach(c -> {
            System.out.println(curve.getMaxAtLevelFormatted(c, 1, 1));
            for (int i = 1; i < 5; ++i) {
                System.out.println(curve.getMaxAtLevelFormatted(c, i * 20, 1));
            }
            System.out.println(curve.getMaxAtLevelFormatted(c, 99, 1));
            System.out.println(" --- ");
        });

        for (int i = 1; i < 100; ++i) {
            System.out.println(curve.getMaxAtLevelFormatted(BasicCurveStrength.XP, i, 1));
        }
    }
}
