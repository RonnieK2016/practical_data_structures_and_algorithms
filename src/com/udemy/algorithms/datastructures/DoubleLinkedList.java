package com.udemy.algorithms.datastructures;

public class DoubleLinkedList<E> {

    Node head;
    Node tail;
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
        return tail != null ? tail.value : null;
    }

    private Node getLastNode() {
        return tail;
    }

    private Node getNodeAt(int index) {
        Node c = head;
        int i = 1;
        while(i < index && c != null) {
            c = c.next;
            i++;
        }

        return c;
    }

    public E getValueAt(int index) {
        Node nodeAt = getNodeAt(index);

        return nodeAt != null ? nodeAt.value : null;
    }

    public void insertFirst(E value) {
        Node newNode = new Node(value);
        newNode.next = head;
        if(head != null) {
            head.previous = newNode;
        }

        if(tail == null) {
            tail = newNode;
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
            tail = newNode;
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
            tail = null;
        }
        else {
            Node previous = last.previous;
            previous.next = null;
            last.previous = null;
            tail = previous;
        }

        return last.value;
    }

    public void insertAt(int index, E value) {
        Node nodeAt = getNodeAt(index);

        if(nodeAt == null) {
            insertLast(value);
            return;
        }

        Node previousNode = nodeAt.previous;
        Node newNode = new Node(value);
        newNode.next = nodeAt;
        newNode.previous = previousNode;
        nodeAt.previous = newNode;
        //head node case
        if(previousNode == null) {
             head = newNode;
        }
        else {
            previousNode.next = newNode;
        }
        size++;
    }

    public E deleteAt(int index) {
        Node nodeAt = getNodeAt(index);

        if(nodeAt == null) {
            return null;
        }

        size--;
        //head node case
        if(nodeAt.previous == null) {
            head = nodeAt.next;
        }
        else {
            nodeAt.previous.next = nodeAt.next;
        }

        //tail node case
        if(nodeAt.next == null) {
            tail = nodeAt.previous;
        }
        else {
            nodeAt.next.previous = nodeAt.previous;
        }

        return nodeAt.value;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

}
