package com.henez.distant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.henez.distant.atlas.Atlas;
import com.henez.distant.atlas.ImgTiles;
import com.henez.distant.debug.DebugDrawer;
import com.henez.distant.enums.Colors;
import com.henez.distant.global.Static;
import com.henez.distant.input.In;
import com.henez.distant.misc.Framerate;
import com.henez.distant.misc.screenshotter.Screenshotter;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.renderer.Shaper;
import com.henez.distant.world.World;

class Distant {

    private boolean firstDrawComplete = false;

    private In in;
    private DebugDrawer debugDrawer;
    private Framerate framerate;
    private World world;

    Distant() {
        in = new In();
        debugDrawer = new DebugDrawer();
        framerate = new Framerate();
        world = new World();
    }

    public void input() {
        in.capture();
    }

    public void update() {
        framerate.update();
        world.update();
    }

    public void draw() {
        Batcher batch = Static.renderer.batcher;
        Shaper shape = Static.renderer.shaper;
        Gdx.gl.glClearColor(Colors.black.color.r, Colors.black.color.g, Colors.black.color.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        world.draw(batch);
        batch.draw(Atlas.get(ImgTiles.GRASS), 16, 16);
        batch.end();

        shape.begin(ShapeRenderer.ShapeType.Filled);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        debugDrawer.draw(shape);
        shape.end();

        batch.begin();
        debugDrawer.draw(batch, framerate, world);
        batch.end();
    }

    public void post() {
        if (!firstDrawComplete && framerate.getSecondsSinceGameStart() > 4) {
            firstDrawComplete = true;
            Screenshotter.saveScreenshot();
        }
    }
}
