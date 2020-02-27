package com.henez.distant.enums;

public enum Facing {
    RIGHT(0, 1, 0),
    UP(1, 0, -1),
    LEFT(2, -1, 0),
    DOWN(3, 0, 1),
    ;

    public final int dir;
    public final int tx;
    public final int ty;

    public static final int COUNT = 4;

    Facing(int dir, int tx, int ty) {
        this.dir = dir;
        this.tx = tx;
        this.ty = ty;
    }
}
