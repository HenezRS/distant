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
    private HashMap<String, SpriteAnimation> animations;
    private Animation animation;

    public Sprite(TextureRegion tex) {
        animation = Animation.none;
        animations = new HashMap<>();
        animations.put(animation.name, new SpriteAnimation(Global.SEC, tex));
    }

    public void update() {
        animations.get(animation.name).update();
    }

    public void draw(Rect pos, Batcher batch) {
        batch.draw(animations.get(animation.name).getCurrent(), pos);
    }

    public void draw(Rect pos, Batcher batch, Facing facing2) {
        batch.draw(animations.get(animation.name).getCurrent(), pos, facing2);
    }

    public void setAnimationReset(Animation animation) {
        setAnimation(animation);
        animations.get(animation.name).reset();
    }

    public void setAnimationContinued(Animation newAnimation) {
        SpriteAnimation lastAnimation = animations.get(animation.name);
        setAnimation(newAnimation);
        animations.get(animation.name).sync(lastAnimation);
    }
}
