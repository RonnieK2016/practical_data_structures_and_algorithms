package com.udemy.algorithms.datastructures;

public class Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    class Node {
        E value;
        Node next;

        Node(E value) {
            this.value = value;
        }
    }

    public Queue() { }

    public E peek() {
        return head != null ? head.value : null;
    }

    public E poll() {
        if(head == null) {
            return null;
        }

        size--;
        E obj = head.value;
        head = head.next;

        if(head == null) {
            tail = null;
        }

        return obj;
    }

    public void offer(E value) {
        if(head == null) {
            head = new Node(value);
            tail = head;
        }
        else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }


}
