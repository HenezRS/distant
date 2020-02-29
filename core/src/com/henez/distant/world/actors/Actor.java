package com.henez.distant.world.actors;

import com.henez.distant.enums.Facing;
import com.henez.distant.enums.animation.Animation;
import com.henez.distant.global.Global;
import com.henez.distant.global.Static;
import com.henez.distant.misc.GameState;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.actions.Movement;
import com.henez.distant.world.animation.Animated;
import com.henez.distant.world.animation.Sprite;
import com.henez.distant.world.map.Map;
import lombok.Getter;

@Getter
public class Actor extends Animated {
    protected Movement movement;
    protected Facing facing;
    protected boolean moveCompletedThisFrame = false;

    public Actor(int gx, int gy, Sprite sprite) {
        super(gx * Global.tilePixel, gy * Global.tilePixel, sprite);
        movement = new Movement();
        facing = Facing.DOWN;
    }

    @Override public void update() {
        moveCompletedThisFrame = false;
        if (movement.update()) {
            move(movement.addMoveX(), movement.addMoveY());
            if (!movement.isMoving()) {
                completeMove();
            }
        }
        super.update();
    }

    private void completeMove() {
        sprite.setAnimationContinued(Animation.idle);
        moveCompletedThisFrame = true;
        snapToGrid();
    }

    public boolean canMove(Facing facing, Map map) {
        return Static.gs == GameState.WORLD && map.tileIsWalkable(gpos.getIntX() + facing.tx, gpos.getIntY() + facing.ty);
    }

    public void beginMove(Facing facing) {
        sprite.setAnimationContinued(Animation.move);
        sprite.setFacing(facing);
        movement.begin(facing);
        this.facing = facing;
    }

    @Override public void draw(Batcher batch) {
        super.draw(batch);
    }
}
