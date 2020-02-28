package com.henez.distant.world.positioned;

import com.henez.distant.datastructures.Rect;
import com.henez.distant.global.Global;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Positioned {
    protected Rect pos;
    protected Rect gpos;

    public Positioned(int x, int y) {
        set(x, y);
    }

    public Positioned(int x, int y, int w, int h) {
        set(x, y, w, h);
    }

    public Positioned(Rect pos) {
        set(pos.getIntX(), pos.getIntY());
    }

    public void move(float x, float y) {
        pos.x += x;
        pos.y += y;
    }

    protected void snapToGrid() {
        gpos.x = (int) pos.x / Global.tilePixel;
        gpos.y = (int) pos.y / Global.tilePixel;
    }

    public void set(int x, int y, int w, int h) {
        pos = new Rect(x, y, w, h);
        gpos = new Rect(x / Global.tilePixel, y / Global.tilePixel, w / Global.tilePixel, h / Global.tilePixel);
    }

    public void set(int x, int y) {
        pos = new Rect(x, y);
        gpos = new Rect(x / Global.tilePixel, y / Global.tilePixel);
    }

    public void setG(int x, int y) {
        pos = new Rect(x * Global.tilePixel, y * Global.tilePixel);
        gpos = new Rect(x, y);
    }

    public int getX() {
        return pos.getIntX();
    }

    public int getY() {
        return pos.getIntY();
    }

    public void setX(int x) {
        pos.setIntX(x);
    }

    public void setY(int y) {
        pos.setIntY(y);
    }

    public int getGX() {
        return gpos.getIntX();
    }

    public int getGY() {
        return gpos.getIntY();
    }

    public int getGW() {
        return gpos.w;
    }

    public int getGH() {
        return gpos.h;
    }

    public void setGX(int x) {
        gpos.setIntX(x);
    }

    public void setGY(int y) {
        gpos.setIntY(y);
    }

    public boolean isGridPos(int x, int y) {
        return gpos.getIntX() == x && gpos.getIntY() == y;
    }
}
