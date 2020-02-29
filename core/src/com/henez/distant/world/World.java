package com.henez.distant.world;

import com.henez.distant.enums.animation.Animation;
import com.henez.distant.enums.animation.AnimationComplete;
import com.henez.distant.global.Global;
import com.henez.distant.global.Static;
import com.henez.distant.misc.GameState;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.actors.Actor;
import com.henez.distant.world.actors.player.Player;
import com.henez.distant.world.animation.Sprite;
import com.henez.distant.world.battle.Battle;
import com.henez.distant.world.map.Map;
import com.henez.distant.world.map.MapLoader;
import lombok.Getter;

@Getter
public class World {
    Map map;
    Player player;
    Actor enemy;
    Battle battle;

    public World() {
        map = MapLoader.load("maps/distant.tmx");
        player = new Player(9, 9, new Sprite());
        player.addAnimation(Animation.idle, Global.SEC2, 1.0f, AnimationComplete.PLAYER);
        player.addAnimation(Animation.move, Global.SEC2, 3.0f, AnimationComplete.PLAYER);
        player.setAnimation(Animation.idle);
    }

    public void update() {
        player.update(map);
        if (player.isTriggerBattle()) {
            battle = new Battle(player, createEnemy(player));
        }

        if (Static.gs == GameState.BATTLE) {
            battle.update();
        }

        Static.renderer.positionCameraOn(player.getPos());
    }

    public void draw(Batcher batch) {
        map.draw(batch);

        if (Static.gs == GameState.BATTLE) {
            drawBattle(batch);
        } else {
            drawWorld(batch);
        }
    }

    private void drawBattle(Batcher batch) {
        battle.draw(batch);
    }

    private void drawWorld(Batcher batch) {
        player.draw(batch);
    }

    private Actor createEnemy(Player player) {
        enemy = new Actor(player.getGX() + player.getFacing().tx, player.getGY() + player.getFacing().ty, new Sprite());
        enemy.addAnimation(Animation.idle, Global.SEC2, 1.0f, AnimationComplete.ENEMY);
        enemy.setAnimation(Animation.idle);
        return enemy;
    }
}
