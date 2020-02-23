package com.henez.distant.global;

import com.henez.distant.renderer.Renderer;
import com.henez.distant.text.Text;

public class Static {
    public static Renderer renderer;
    public static Text text;

    private Static() {
    }

    public static void load() {
        renderer = new Renderer();
        text = new Text();
        text.load();
    }
}
