package com.henez.distant.world;

import com.henez.distant.atlas.Atlas;
import com.henez.distant.atlas.ImgActors;
import com.henez.distant.enums.Animation;
import com.henez.distant.global.Global;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.actors.Actor;
import com.henez.distant.world.actors.player.Player;
import com.henez.distant.world.animation.Sprite;
import com.henez.distant.world.animation.SpriteAnimation;
import com.henez.distant.world.map.Map;

public class World {
    Map map;
    Actor player;

    public World() {
        map = new Map(0, 0, 18, 18);
        player = new Player(9, 9, new Sprite(Atlas.get(ImgActors.PLAYER_0)));
        player.giveAnimation(Animation.idle, new SpriteAnimation(Global.SEC2, Atlas.get(ImgActors.PLAYER_0), Atlas.get(ImgActors.PLAYER_1)));
        player.giveAnimation(Animation.move, new SpriteAnimation(Global.SEC2, 3.0f, Atlas.get(ImgActors.PLAYER_0), Atlas.get(ImgActors.PLAYER_1)));
        player.setAnimation(Animation.idle);
    }

    public void update() {
        player.update(map);
    }

    public void draw(Batcher batch) {
        player.draw(batch);
    }
}
