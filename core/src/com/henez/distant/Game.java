package com.henez.distant;

import com.badlogic.gdx.ApplicationAdapter;
import com.henez.distant.atlas.Atlas;
import com.henez.distant.global.Static;

public class Game extends ApplicationAdapter {

    private Distant distant;

    @Override
    public void create() {
        Static.load();
        Atlas.load();
        distant = new Distant();
    }

    @Override
    public void render() {
        distant.input();
        distant.update();
        distant.draw();
        distant.post();
    }

    @Override
    public void dispose() {
    }
}
