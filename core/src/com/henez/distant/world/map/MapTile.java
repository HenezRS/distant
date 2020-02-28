package com.henez.distant.world.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.henez.distant.atlas.Atlas;
import com.henez.distant.atlas.ImgTiles;
import com.henez.distant.global.Global;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.positioned.Positioned;
import lombok.Getter;

@Getter
public class MapTile extends Positioned {
    TextureRegion tex;
    ImgTiles tile;

    public MapTile(int gx, int gy, ImgTiles tile) {
        super(gx * Global.tilePixel, gy * Global.tilePixel);
        this.tile = tile;
        tex = Atlas.get(tile);
    }

    public void draw(Batcher batch) {
        batch.draw(tex, pos);
    }

    public boolean isWalkable() {
        return tile.tileType.walkable;
    }
}
