package com.henez.distant.world.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.henez.distant.enums.TileType;
import com.henez.distant.global.Global;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.positioned.Positioned;
import lombok.Getter;
import lombok.Setter;

@Getter
public class MapTile extends Positioned {
    TextureRegion tex;

    @Setter
    TileType type;

    public MapTile(int gx, int gy) {
        super(gx * Global.tilePixel, gy * Global.tilePixel);
    }

    public void draw(Batcher batch) {
        batch.draw(tex, pos);
    }
}
