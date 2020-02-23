package com.henez.distant.world.actions;

import com.henez.distant.enums.Facing;
import com.henez.distant.global.Global;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movement {
    Facing facing;
    float speed = 1.0f;
    float progress;
    float goal;
    boolean isMoving;

    public Movement() {
        isMoving = false;
    }

    public boolean update() {
        if (isMoving) {
            progress += speed;
            if (progress >= goal) {
                progress = goal;
                finish();
                return true;
            }
        }

        return isMoving;
    }

    public void begin(Facing facing) {
        isMoving = true;
        this.facing = facing;
        progress = 0;
        goal = Global.tilePixel;
    }

    public float addMoveX() {
        return facing.tx * speed;
    }

    public float addMoveY() {
        return facing.ty * speed;
    }

    private void finish() {
        isMoving = false;
    }
}
