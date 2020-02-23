package com.henez.distant.world.animation;

import com.henez.distant.enums.Animation;
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

    public void giveAnimation(Animation animation, SpriteAnimation spriteAnimation) {
        sprite.getAnimations().put(animation.name, spriteAnimation);
    }

    public void setAnimation(Animation animation) {
        sprite.setAnimation(animation);
    }
}
