package com.henez.distant.atlas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Arrays;

public class Atlas {
    private static TextureRegion[][] textureRegionTiles;
    private static TextureRegion[][] textureRegionActors;

    public static void load() {
        textureRegionTiles = loadRegionFromPng("png/tiles.png");
        textureRegionActors = loadRegionFromPng("png/actors.png");
    }

    private static TextureRegion[][] loadRegionFromPng(String png) {
        Texture texture = new Texture(Gdx.files.internal(png));
        TextureRegion[][] region = TextureRegion.split(texture, 16, 16);
        Arrays.stream(region).forEach(r -> Arrays.stream(r).forEach(rr -> rr.flip(false, true)));
        return region;

    }

    public static TextureRegion get(ImgTiles img) {
        return textureRegionTiles[img.y][img.x];
    }

    public static TextureRegion get(ImgActors img) {
        return textureRegionActors[img.y][img.x];
    }
}
