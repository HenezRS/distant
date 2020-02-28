package com.henez.distant.world.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.henez.distant.atlas.ImgTiles;
import com.henez.distant.datastructures.GameList;

import java.util.Arrays;
import java.util.List;

public class MapLoader {
    private MapLoader() {
    }

    public static Map load(String mapFilePath) {
        GameList<MapTile> tiles = new GameList<>();

        XmlReader reader = new XmlReader();
        Element root = reader.parse(Gdx.files.internal(mapFilePath));
        int width = root.getInt("width");
        int height = root.getInt("height");
        Element layer = root.getChildByName("layer");
        Element data = layer.getChildByName("data");
        List<String> items = Arrays.asList(data.getText().split("\\s*,\\s*"));

        int index = 0;
        for (int j = 0; j < height; ++j) {
            for (int i = 0; i < width; ++i) {
                tiles.add(new MapTile(i, j, ImgTiles.getByValue(Integer.parseInt(items.get(index)) - 1)));
                index++;
            }
        }

        Map map = new Map(width, height, tiles);

        return map;
    }
}
