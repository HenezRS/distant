package com.henez.distant.datastructures;

import java.util.ArrayList;

public class GameList<T> extends ArrayList<T> {

    public T random() {
        if (size() == 0)
            return null;
        return get(Numbers.nextIntBetween(0, size() - 1));
    }

    public T getOrNull(int i) {
        try {
            return get(i);
        } catch (IndexOutOfBoundsException ignored) {
            return null;
        }
    }

    public T first() {
        return get(0);
    }
}
