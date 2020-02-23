package com.henez.distant.debug;

import com.henez.distant.datastructures.GameList;
import com.henez.distant.datastructures.Rect;
import com.henez.distant.enums.Colors;
import com.henez.distant.global.Static;
import com.henez.distant.input.In;
import com.henez.distant.misc.Framerate;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.renderer.Shaper;
import com.henez.distant.text.Text;

import java.util.concurrent.atomic.AtomicInteger;

public class DebugDrawer {
    private GameList<String> lines;

    public DebugDrawer() {
        lines = new GameList<>();
    }

    public void draw(Batcher batch, Framerate framerate) {
        lines.clear();
        lines.add(In.showHeld());
        lines.add(String.format("FPS: %s - Time: %s", framerate.getFrameRate(), framerate.getSecondsSinceGameStart()));
        lines.add(String.format("camera: %s,%s", Static.renderer.getX(), Static.renderer.getY()));
        lines.add(String.format("mouse: %s,%s [%s,%s] {%s,%s}",
                                In.mouse.getWx(),
                                In.mouse.getWy(),
                                In.mouse.getGx(),
                                In.mouse.getGy(),
                                In.mouse.getX(),
                                In.mouse.getY()));
        /*lines.add(String.format("player: %s,%s [%s,%s]",
                                (int) Static.world.getPlayer().getX(),
                                (int) Static.world.getPlayer().getY(),
                                Static.world.getPlayer().getGx(),
                                Static.world.getPlayer().getGy()));*/

        int height = lines.size() * Text.TEXT_LINE_H;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        lines.forEach(line -> {
            atomicInteger.getAndIncrement();
            Static.text.draw(batch, line, Static.renderer.getX() + 4, Static.renderer.getYY() - (height + 4 + Text.TEXT_H) + (atomicInteger.get() * Text.TEXT_LINE_H));
        });
    }

    public void draw(Shaper shape) {
        shape.rect(new Rect(In.mouse.getGx() * 16, In.mouse.getGy() * 16), Colors.text_default.mul(0.75f, 0.35f));
    }
}
