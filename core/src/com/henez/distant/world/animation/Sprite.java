package com.henez.distant.world.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.henez.distant.datastructures.Rect;
import com.henez.distant.enums.Animation;
import com.henez.distant.enums.Facing;
import com.henez.distant.global.Global;
import com.henez.distant.renderer.Batcher;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Sprite {
    private HashMap<Animation, SpriteAnimation> animations;
    private Animation animation;

    public Sprite(TextureRegion tex) {
        animation = Animation.none;
        animations = new HashMap<>();
        animations.put(animation, new SpriteAnimation(Global.SEC, tex));
    }

    public void update() {
        current().update();
    }

    public void draw(Rect pos, Batcher batch) {
        batch.draw(current().getCurrent(), pos);
    }

    public void draw(Rect pos, Batcher batch, Facing facing2) {
        batch.draw(current().getCurrent(), pos, facing2);
    }

    public void setAnimationReset(Animation animation) {
        setAnimation(animation);
        animations.get(animation).reset();
    }

    public void setAnimationContinued(Animation newAnimation) {
        SpriteAnimation lastAnimation = current();
        setAnimation(newAnimation);
        current().sync(lastAnimation);
    }

    private SpriteAnimation current() {
        return animations.get(animation);
    }
}
