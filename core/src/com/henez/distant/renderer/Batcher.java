package com.henez.distant.renderer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.henez.distant.datastructures.Rect;
import com.henez.distant.enums.Facing;
import com.henez.distant.global.Global;

public class Batcher extends SpriteBatch {
    private int tx;
    private int ty;

    public Batcher() {
        super();
        resetTransform();
    }

    public void addTransform(int x, int y) {
        tx = x;
        ty = y;
    }

    public void resetTransform() {
        tx = 0;
        ty = 0;
    }

    public void draw(Texture region, Rect pos) {
        super.draw(region, pos.x + tx, pos.y + ty);
    }

    @Override public void draw(Texture region, float x, float y) {
        super.draw(region, x + tx, y + ty);
    }

    public void draw(TextureRegion region, Rect pos) {
        super.draw(region, pos.x + tx, pos.y + ty);
    }

    @Override public void draw(TextureRegion region, float x, float y) {
        super.draw(region, x + tx, y + ty);
    }

    public void draw(TextureRegion region, Rect pos, Facing facing2) {
        draw(region, pos.x, pos.y, facing2);
    }

    public void draw(TextureRegion region, float x, float y, Facing facing2) {
        if (facing2 == Facing.RIGHT) {
            super.draw(region, x + tx + Global.tilePixel, y + ty, -Global.tilePixel, Global.tilePixel);
        } else {
            super.draw(region, x + tx, y + ty);
        }
    }
}
