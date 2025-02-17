package org.functionalbits.fundamentals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queue<T> implements Iterable<T> {
    private final List<T> elements = new ArrayList<>();

    public Queue() {}

    public void enqueue(T item) {
        elements.add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node<T> {
        private boolean isHead = false;
        private Node<T> next = null;

        public Node(T item) {

        }
    }
}
