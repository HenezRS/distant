package com.henez.distant.world.actors.fighter.player;

import com.henez.distant.datastructures.Numbers;
import com.henez.distant.enums.Facing;
import com.henez.distant.input.In;
import com.henez.distant.world.actors.fighter.Fighter;
import com.henez.distant.world.animation.Sprite;
import com.henez.distant.world.map.Map;
import lombok.Getter;

import java.util.Optional;

@Getter
public class Player extends Fighter {

    private int stepsUntilBattle;
    private boolean triggerBattle;

    public Player(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        resetStepsUntilBattle();
    }

    public void update(Map map) {
        triggerBattle = false;
        if (!movement.isMoving()) {
            pollInputMovement().ifPresent(facing -> {
                if (canMove(facing, map)) {
                    beginMove(facing);
                }
            });
        }

        super.update();

        if (moveCompletedThisFrame) {
            takeStep();
        }
    }

    private Optional<Facing> pollInputMovement() {
        return In.right.isHeld() ? Optional.of(Facing.RIGHT) : In.up
                .isHeld() ? Optional.of(Facing.UP) : In.left
                .isHeld() ? Optional.of(Facing.LEFT) : In.down
                .isHeld() ? Optional.of(Facing.DOWN) : Optional.empty();
    }

    public void resetStepsUntilBattle() {
        stepsUntilBattle = Numbers.nextIntBetween(6, 18);
    }

    private void takeStep() {
        stepsUntilBattle--;
        if (stepsUntilBattle <= 0) {
            resetStepsUntilBattle();
            triggerBattle = true;
        }
    }
}
