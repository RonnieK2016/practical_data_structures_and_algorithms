package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.DoubleLinkedList;

public class DoubleLinkedListTest {

    public static void main(String[] args) {
        DoubleLinkedList<Integer> dl = new DoubleLinkedList<>();

        System.out.println("Empty list " + dl.getSize());
        System.out.println("Inserting 4 elements into the beginning");

        dl.insertFirst(1);
        dl.insertFirst(2);
        dl.insertFirst(3);
        dl.insertFirst(4);

        System.out.println("Size after insert " + dl.getSize());
        System.out.println("Inserting 4 elements into the end");
        dl.insertLast(5);
        dl.insertLast(6);
        dl.insertLast(7);
        dl.insertLast(8);
        System.out.println("Size after insert " + dl.getSize());
        System.out.println("Getting first element - " + dl.getFirst());
        System.out.println("Getting last element - " + dl.getLast());

        System.out.println(" Delete first " + dl.deleteFirst());
        System.out.println(" Delete first " + dl.deleteFirst());
        System.out.println("Size after remove " + dl.getSize());

        System.out.println(" Delete last " + dl.deleteLast());
        System.out.println(" Delete last " + dl.deleteLast());
        System.out.println("Size after remove " + dl.getSize());

        System.out.println("Deleting all elements from last");
        while(!dl.isEmpty()) {
            System.out.println("Deleted element " + dl.deleteLast());
        }
        System.out.println("Size after remove " + dl.getSize());

        dl.insertLast(5);
        dl.insertLast(6);
        dl.insertLast(7);
        dl.insertLast(8);
        dl.insertFirst(1);
        dl.insertFirst(2);
        dl.insertFirst(3);
        dl.insertFirst(4);

        System.out.println("Deleting all elements from first");
        while(!dl.isEmpty()) {
            System.out.println("Deleted element " + dl.deleteFirst());
        }
        System.out.println("Size after remove " + dl.getSize());
    }
}
