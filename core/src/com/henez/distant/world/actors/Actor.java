package com.henez.distant.world.actors;

import com.henez.distant.enums.Animation;
import com.henez.distant.enums.Facing;
import com.henez.distant.global.Global;
import com.henez.distant.renderer.Batcher;
import com.henez.distant.world.actions.Movement;
import com.henez.distant.world.animation.Animated;
import com.henez.distant.world.animation.Sprite;
import com.henez.distant.world.map.Map;

public class Actor extends Animated {
    protected Movement movement;
    protected Facing facing;

    public Actor(int gx, int gy, Sprite sprite) {
        super(gx * Global.tilePixel, gy * Global.tilePixel, sprite);
        movement = new Movement();
        facing = Facing.DOWN;
    }

    public void update(Map map) {
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
        snapToGrid();
    }

    public boolean canMove(Facing facing, Map map) {
        return map.tileIsWalkable(gpos.getIntX() + facing.tx, gpos.getIntY() + facing.ty);
    }

    public void beginMove(Facing facing) {
        sprite.setAnimationContinued(Animation.move);
        movement.begin(facing);
        this.facing = facing;
    }

    public void draw(Batcher batch) {
        //int drawX = Numbers.round(pos.x);
        //int drawY = Numbers.round(pos.y);
        sprite.draw(pos, batch, facing);
    }
}
