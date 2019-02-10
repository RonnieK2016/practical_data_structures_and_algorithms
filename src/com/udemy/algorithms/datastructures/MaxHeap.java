package com.udemy.algorithms.datastructures;

public class MaxHeap<E extends Comparable<E>> extends Heap<E> {


    public MaxHeap(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    boolean shouldSwap(E parent, E child) {
        return parent.compareTo(child) < 0;
    }

    @Override
    int getIndexToSwap(E left, int leftIndex, E right, int rightIndex) {
        if(left == null) {
            return rightIndex;
        }
        else if (right == null) {
            return leftIndex;
        }
        else {
            if(left.compareTo(right) < 0) {
                return rightIndex;
            }
            else {
                return leftIndex;
            }
        }
    }

    public E getMax() {
        return getTop();
    }

    public E exctractMax() {
        return extractTop();
    }
}
