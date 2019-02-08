package com.udemy.algorithms.datastructures;

public class DoubleLinkedList<E> {

    Node head;
    int size;

    class Node {
        E value;
        Node next;
        Node previous;

        Node(E value) {
            this.value = value;
        }
    }

    public E getFirst() {
        return head != null ? head.value : null;
    }

    public E getLast() {
        Node last = getLastNode();
        return last != null ? last.value : null;
    }

    private Node getLastNode() {
        Node c = head;
        if(c == null) {
            return null;
        }

        while(c.next != null) {
            c = c.next;
        }

        return c;
    }

    public void insertFirst(E value) {
        Node newNode = new Node(value);
        newNode.next = head;
        if(head != null) {
            head.previous = newNode;
        }
        head = newNode;
        size++;
    }

    public void insertLast(E value) {
        Node lastNode = getLastNode();

        if(lastNode == null) {
            insertFirst(value);
        }
        else {
            Node newNode = new Node(value);
            newNode.previous = lastNode;
            lastNode.next = newNode;
            size++;
        }
    }

    public E deleteFirst() {
        if(head == null) {
            return null;
        }
        else {
            E value = head.value;
            head = head.next;
            if(head != null) {
                head.previous = null;
            }
            size--;
            return value;
        }
    }

    public E deleteLast() {
        Node last = getLastNode();

        if(last == null) {
            return null;
        }

        size--;
        if(size == 0) {
            head = null;
        }
        else {
            Node previous = last.previous;
            previous.next = null;
            last.previous = null;
        }

        return last.value;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

}
