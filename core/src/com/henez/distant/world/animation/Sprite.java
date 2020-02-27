package com.henez.distant.world.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.henez.distant.datastructures.GameList;
import com.henez.distant.datastructures.Rect;
import com.henez.distant.enums.Facing;
import com.henez.distant.enums.animation.Animation;
import com.henez.distant.enums.animation.AnimationComplete;
import com.henez.distant.enums.animation.AnimationSet;
import com.henez.distant.renderer.Batcher;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;

@Getter
@Setter
public class Sprite {
    private GameList<HashMap<Animation, SpriteAnimation>> animations;
    private Animation animation;
    private Facing facing;
    private boolean downOnly;

    public Sprite() {
        super();
        animations = new GameList<>();
        Arrays.stream(Facing.values()).forEach(a -> animations.add(new HashMap<>()));
        facing = Facing.DOWN;
        downOnly = false;
    }

    public void update() {
        current().update();
    }

    public void draw(Rect pos, Batcher batch) {
        batch.draw(current().getCurrent(), pos.getIntX(), pos.getIntY());
    }

    public void setFacing(Facing facing) {
        this.facing = downOnly ? Facing.DOWN : facing;
    }

    public void addAnimation(Animation animation, float delay, float speed, AnimationComplete animationComplete) {
        if (animationComplete.downOnly) {
            buildSpriteAnimationsDownOnly(animation, delay, speed, animationComplete);
        } else {
            buildSpriteAnimations(animation, delay, speed, animationComplete);
        }
    }

    private void buildSpriteAnimationsDownOnly(Animation animation, float delay, float speed, AnimationComplete animationComplete) {
        downOnly = true;
        int dir = Facing.DOWN.dir;
        AnimationSet animationSet = animationComplete.animationSets.first();
        animations.get(dir).put(animation, new SpriteAnimation(delay, speed, animationSet.texs.toArray(new TextureRegion[0])));

    }

    private void buildSpriteAnimations(Animation animation, float delay, float speed, AnimationComplete animationComplete) {
        for (int i = 0; i < Facing.COUNT; ++i) {
            AnimationSet animationSet = animationComplete.animationSets.get(i);
            animations.get(i).put(animation, new SpriteAnimation(delay, speed, animationSet.texs.toArray(new TextureRegion[0])));
        }
    }

    public void setAnimationReset(Animation animation) {
        setAnimation(animation);
        current().reset();
    }

    public void setAnimationContinued(Animation newAnimation) {
        SpriteAnimation lastAnimation = current();
        setAnimation(newAnimation);
        current().sync(lastAnimation);
    }

    private SpriteAnimation current() {
        return animations.get(facing.dir).get(animation);
    }
}
