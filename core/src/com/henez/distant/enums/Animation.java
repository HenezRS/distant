package com.henez.distant.enums;

public enum Animation {
    none("NONE"),
    idle("IDLE"),
    move("MOVE"),
    ;

    public final String name;

    Animation(String name) {
        this.name = name;
    }
}
