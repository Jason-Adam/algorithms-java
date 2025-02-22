package org.functionalbits.fundamentals;

import java.util.Objects;

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void add(E element) {
        Node<E> node = new Node<>(element);

        if (head == null) {
            head = node;
            tail = Objects.requireNonNullElse(head.next, node);
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    boolean contains(E element) {
        var currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData().equals(element)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    void remove(E element) {
        var currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData().equals(element)) {
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
                break;
            }

            currentNode = currentNode.next;
        }
    }

    E getHead() {
        return head.getData();
    }

    E getTail() {
        return tail.getData();
    }
}
