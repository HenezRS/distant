package com.henez.distant.enums.stats;

import com.henez.distant.datastructures.Numbers;
import lombok.Getter;

@Getter
public enum BasicCurveStrength {
    F("F", 3, 0.3f),
    E("E", 4, 0.43f),
    D("D", 4, 0.56f),
    C("C", 5, 0.7f),
    B("B", 5, 0.835f),
    A("A", 6, 0.98f),
    AA("AA", 6, 1.135f),
    AAA("AAA", 7, 1.245f),
    S("S", 8, 1.325f),
    XP("XP", 10, 3.85f),
    ;

    private final String name;
    private final float base;
    private final float add;

    BasicCurveStrength(String name, float base, float add) {
        this.name = name;
        this.base = base;
        this.add = add;
    }

    public static BasicCurveStrength getRandom() {
        return BasicCurveStrength.values()[Numbers.nextIntBetween(0, 8)];
    }

}
