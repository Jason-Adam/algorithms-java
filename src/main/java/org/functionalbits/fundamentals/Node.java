package org.functionalbits.fundamentals;

public class Node<E> {
    private final E data;
    Node<E> previous;
    Node<E> next;

    protected Node(E data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public E getData() {
        return data;
    }
}
