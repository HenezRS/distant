package com.henez.distant.world.battle;

import com.henez.distant.global.Global;
import com.henez.distant.global.Static;
import com.henez.distant.misc.GameState;
import com.henez.distant.misc.timer.Timer;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.actors.Actor;

public class Battle {
    private Actor player;
    private Actor enemy;
    private Timer timer;

    public Battle(Actor player, Actor enemy) {
        this.player = player;
        this.enemy = enemy;
        timer = new Timer(Global.SEC * 3);
        Static.gs = GameState.BATTLE;
    }

    public void update() {
        if (timer.update()) {
            playerWin();
        }

        enemy.update();
    }

    public void draw(Batcher batch) {
        player.draw(batch);
        enemy.draw(batch);
    }

    private void playerWin() {
        Static.gs = GameState.WORLD;
    }
}