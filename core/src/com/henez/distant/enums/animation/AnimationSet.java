package com.henez.distant.enums.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.henez.distant.atlas.Atlas;
import com.henez.distant.atlas.ImgActors;
import com.henez.distant.datastructures.GameList;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.henez.distant.atlas.ImgActors.ENEMY_0;
import static com.henez.distant.atlas.ImgActors.ENEMY_1;
import static com.henez.distant.atlas.ImgActors.PLAYER_d0;
import static com.henez.distant.atlas.ImgActors.PLAYER_d1;
import static com.henez.distant.atlas.ImgActors.PLAYER_l0;
import static com.henez.distant.atlas.ImgActors.PLAYER_l1;
import static com.henez.distant.atlas.ImgActors.PLAYER_r0;
import static com.henez.distant.atlas.ImgActors.PLAYER_r1;
import static com.henez.distant.atlas.ImgActors.PLAYER_u0;
import static com.henez.distant.atlas.ImgActors.PLAYER_u1;

public enum AnimationSet {
    PLAYER_R(PLAYER_r0, PLAYER_r1),
    PLAYER_U(PLAYER_u0, PLAYER_u1),
    PLAYER_L(PLAYER_l0, PLAYER_l1),
    PLAYER_D(PLAYER_d0, PLAYER_d1),
    ENEMY(ENEMY_0, ENEMY_1);

    public final GameList<TextureRegion> texs;

    AnimationSet(ImgActors... imgs) {
        this.texs = Arrays.stream(imgs).map(Atlas::get).collect(Collectors.toCollection(GameList::new));
    }
}
