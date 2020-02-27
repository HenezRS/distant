package com.henez.distant.enums.animation;

import com.henez.distant.datastructures.GameList;

import java.util.Arrays;

import static com.henez.distant.enums.animation.AnimationSet.PLAYER_D;
import static com.henez.distant.enums.animation.AnimationSet.PLAYER_L;
import static com.henez.distant.enums.animation.AnimationSet.PLAYER_R;
import static com.henez.distant.enums.animation.AnimationSet.PLAYER_U;

public enum AnimationComplete {
    PLAYER(PLAYER_R, PLAYER_U, PLAYER_L, PLAYER_D),
    ENEMY(AnimationSet.ENEMY);

    public final GameList<AnimationSet> animationSets;
    public boolean downOnly = false;

    AnimationComplete(AnimationSet... animationSetArray) {
        this.animationSets = new GameList<>();
        animationSets.addAll(Arrays.asList(animationSetArray));
        if (animationSets.size() <= 1) {
            this.downOnly = true;
        }
    }
}
