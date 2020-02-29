package com.henez.distant.global;

import com.henez.distant.misc.GameState;
import com.henez.distant.renderer.Renderer;
import com.henez.distant.text.Text;

public class Static {
    public static Renderer renderer;
    public static Text text;
    public static GameState gs;

    private Static() {
    }

    public static void load() {
        gs = GameState.WORLD;
        renderer = new Renderer();
        text = new Text();
        text.load();
    }
}
