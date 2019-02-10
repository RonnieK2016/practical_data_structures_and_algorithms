package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.MaxHeap;
import com.udemy.algorithms.datastructures.MinHeap;

public class HeapTest {

    private static void maxHeapTest() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);

        maxHeap.insert(-10);
        maxHeap.insert(8);
        maxHeap.insert(4);
        maxHeap.insert(6);
        maxHeap.insert(15);
        maxHeap.insert(-1);
        maxHeap.insert(-8);
        maxHeap.insert(12);

        System.out.println("--------------------------------");
        System.out.println("Testing max heap: ");

        System.out.println("Size of heap " + maxHeap.getSize());

        System.out.println("Printing heap " + maxHeap.displayHeap());

        System.out.println("Retrieving elements from heap: ");
        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.exctractMax());
        }
    }

    private static void minHeapTest() {
        MinHeap<Integer> minHeap = new MinHeap<>(10);

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(4);
        minHeap.insert(6);
        minHeap.insert(-1);
        minHeap.insert(-8);

        System.out.println("--------------------------------");
        System.out.println("Testing min heap: ");

        System.out.println("Size of heap " + minHeap.getSize());

        System.out.println("Printing heap " + minHeap.displayHeap());

        System.out.println("Retrieving elements from heap: ");
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.exctractMin());
        }

        System.out.println("\r\n");
    }

    public static void main(String[] args) {
        HeapTest.minHeapTest();
        HeapTest.maxHeapTest();
    }
}
