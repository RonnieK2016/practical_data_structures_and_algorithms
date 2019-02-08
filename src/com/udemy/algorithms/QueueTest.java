package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.Queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println("Check size of queue " + queue.getSize());
        System.out.println("Polling first - " + queue.poll());
        System.out.println("Check size of queue " + queue.getSize());
        System.out.println("Peeking second - " + queue.peek());
        System.out.println("Getting rest of elements");
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println("Check size of queue " + queue.getSize());

        System.out.println("Inserting after list empty");
        queue.offer(10);
        queue.offer(11);
        queue.offer(12);
        System.out.println("Getting rest of elements");
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println("Check size of queue " + queue.getSize());

    }
}
