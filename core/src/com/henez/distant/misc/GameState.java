package com.henez.distant.misc;

public enum GameState {
    NONE("None"),
    WORLD("World"),
    BATTLE("Battle"),
    ;

    private final String name;

    GameState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}