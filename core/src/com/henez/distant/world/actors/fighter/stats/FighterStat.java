package com.henez.distant.world.actors.fighter.stats;

public interface FighterStat {
    void recoverFlat(float amount);

    void recoverPercent(float amount);

    void reset();

    void resetBattleStart();
}
