package com.henez.distant.world.actors.player;

import com.henez.distant.enums.Facing;
import com.henez.distant.input.In;
import com.henez.distant.world.actors.Actor;
import com.henez.distant.world.animation.Sprite;
import com.henez.distant.world.map.Map;

import java.util.Optional;

public class Player extends Actor {
    public Player(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override public void update(Map map) {
        super.update();

        if (!movement.isMoving()) {
            pollInputMovement().ifPresent(facing -> {
                if (canMove(facing, map)) {
                    beginMove(facing);
                }
            });
        }
    }

    private Optional<Facing> pollInputMovement() {
        return In.right.isHeld() ? Optional.of(Facing.RIGHT) : In.up
                .isHeld() ? Optional.of(Facing.UP) : In.left
                .isHeld() ? Optional.of(Facing.LEFT) : In.down
                .isHeld() ? Optional.of(Facing.DOWN) : Optional.empty();
    }
}
