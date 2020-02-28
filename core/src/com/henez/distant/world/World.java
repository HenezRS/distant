package com.henez.distant.world;

import com.henez.distant.enums.animation.Animation;
import com.henez.distant.enums.animation.AnimationComplete;
import com.henez.distant.global.Global;
import com.henez.distant.global.Static;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.actors.Actor;
import com.henez.distant.world.actors.player.Player;
import com.henez.distant.world.animation.Sprite;
import com.henez.distant.world.map.Map;
import com.henez.distant.world.map.MapLoader;
import lombok.Getter;

@Getter
public class World {
    Map map;
    Actor player;
    Actor enemy;

    public World() {
        map = MapLoader.load("maps/distant.tmx");
        player = new Player(9, 9, new Sprite());
        player.addAnimation(Animation.idle, Global.SEC2, 1.0f, AnimationComplete.PLAYER);
        player.addAnimation(Animation.move, Global.SEC2, 3.0f, AnimationComplete.PLAYER);
        player.setAnimation(Animation.idle);

        enemy = new Actor(11, 9, new Sprite());
        enemy.addAnimation(Animation.idle, Global.SEC2, 1.0f, AnimationComplete.ENEMY);
        enemy.setAnimation(Animation.idle);
    }

    public void update() {
        player.update(map);
        enemy.update(map);
        Static.renderer.positionCameraOn(player.getPos());
    }

    public void draw(Batcher batch) {
        map.draw(batch);
        player.draw(batch);
        enemy.draw(batch);
    }
}
