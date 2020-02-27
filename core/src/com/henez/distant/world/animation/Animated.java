package com.henez.distant.world.animation;

import com.henez.distant.enums.animation.Animation;
import com.henez.distant.enums.animation.AnimationComplete;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.positioned.Positioned;

public abstract class Animated extends Positioned {
    protected Sprite sprite;

    public Animated(int x, int y, Sprite sprite) {
        super(x, y);
        this.sprite = sprite;
    }

    protected void update() {
        sprite.update();
    }

    protected void draw(Batcher batch) {
        sprite.draw(pos, batch);
    }

    public void addAnimation(Animation animation, float delay, float speed, AnimationComplete animationComplete) {
        sprite.addAnimation(animation, delay, speed, animationComplete);
    }

    public void setAnimation(Animation animation) {
        sprite.setAnimation(animation);
    }
}
