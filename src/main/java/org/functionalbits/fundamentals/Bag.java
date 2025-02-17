package org.functionalbits.fundamentals;

import java.util.*;

public class Bag<T> implements Iterable<T> {
    private final List<T> elements = new ArrayList<>();

    public Bag(List<T> items) {
        elements.addAll(items);
    }

    public void add(T item) {
        elements.add(item);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
