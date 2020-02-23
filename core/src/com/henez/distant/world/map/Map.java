package com.henez.distant.world.map;

import com.henez.distant.datastructures.GameList;
import com.henez.distant.global.Global;
import com.henez.distant.world.positioned.Positioned;

import java.util.Optional;

public class Map extends Positioned {
    GameList<MapTile> tiles;

    public Map(int gx, int gy, int gw, int gh) {
        super(gx * Global.tilePixel, gy * Global.tilePixel, gw * Global.tilePixel, gh * Global.tilePixel);
        tiles = new GameList<>();
    }

    private Optional<MapTile> tileAt(int x, int y) {
        return tiles.stream().filter(tile -> tile.isGridPos(x, y)).findFirst();
    }

    public Optional<MapTile> getTile(int x, int y) {
        return inBounds(x, y) ? tileAt(x, y) : Optional.empty();
    }

    public boolean tileIsWalkable(int x, int y) {
        return getTile(x, y).isPresent() && getTile(x, y).get().getType().walkable;
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < getX() && y < getY();
    }
}
