package com.henez.distant.global;

import com.henez.distant.debug.Log;
import com.henez.distant.debug.LogLevels;
import com.henez.distant.misc.GameState;
import com.henez.distant.renderer.Renderer;
import com.henez.distant.text.Text;

public class Static {
    public static Renderer renderer;
    public static Text text;
    public static GameState gs;
    public static Log log;

    private Static() {
    }

    public static void load() {
        gs = GameState.WORLD;
        renderer = new Renderer();
        log = new Log(LogLevels.info);
        text = new Text();
        text.load();
    }
}
