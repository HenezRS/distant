package com.henez.distant.atlas;

public enum ImgActors {
    PLAYER_r0(0, 0),
    PLAYER_r1(1, 0),
    PLAYER_u0(2, 0),
    PLAYER_u1(3, 0),
    PLAYER_l0(4, 0),
    PLAYER_l1(5, 0),
    PLAYER_d0(6, 0),
    PLAYER_d1(7, 0),
    ENEMY_0(0, 2),
    ENEMY_1(1, 2),
    ;

    public final int x;
    public final int y;

    ImgActors(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
