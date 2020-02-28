package com.henez.distant.atlas;

import com.henez.distant.enums.TileType;

public enum ImgTiles {
    NONE(0, 0, TileType.none),
    GRASS(1, 0, TileType.floor),
    TREE(2, 0, TileType.floor),
    HILL(3, 0, TileType.floor),
    MOUNTAIN(4, 0, TileType.wall),
    WATER(5, 0, TileType.wall),
    ;

    public final int x;
    public final int y;
    public final TileType tileType;

    ImgTiles(int x, int y, TileType tileType) {
        this.x = x;
        this.y = y;
        this.tileType = tileType;
    }

    public static ImgTiles getByValue(int value) {
        return ImgTiles.values()[value];
    }
}
