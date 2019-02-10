package com.udemy.algorithms.datastructures;

import java.util.Arrays;

public abstract class Heap <E extends Comparable<E>> {

    private Object[] elements;
    private int lastIndex;

    Heap(int initialCapacity) {
        elements = new Object[initialCapacity];
        lastIndex = -1;
    }

    E getTop() {
        return (E) elements[0];
    }

    E getLast() {
        return (E) elements[lastIndex];
    }

    private void ensureCapacity(int newCapacity) {
        if(newCapacity == elements.length) {
            grow();
        }
    }

    private void grow() {
        elements = Arrays.copyOf(elements, (int)(elements.length*1.5));
    }

    public E insert(E item) {
        ensureCapacity(lastIndex + 1);
        elements[++lastIndex] = item;

        heapify(item, lastIndex);

        return item;
    }

    public E extractTop() {
        E top = (E) elements[0];
        swap(0, lastIndex);
        lastIndex--;
        updateHeap(0);
        return top;
    }

    abstract int getIndexToSwap(E left, int leftIndex, E right, int rightIndex);

    abstract boolean shouldSwap(E parent, E child);

    private void updateHeap(int nodeIndex) {
        int leftIndex = 2*nodeIndex + 1;
        int rightIndex = 2*nodeIndex + 2;
        E lChild = getAt(leftIndex);
        E rChild = getAt(rightIndex);
        if (lChild != null || rChild != null) {
            int indexToSwap = getIndexToSwap(lChild, leftIndex, rChild, rightIndex);
            if(shouldSwap(getAt(nodeIndex), getAt(indexToSwap))) {
                swap(nodeIndex, indexToSwap);
                updateHeap(indexToSwap);
            }
        }
    }

    private void heapify(E node, int nodeIndex) {
        if(nodeIndex != 0) {
            int parentIndex = (nodeIndex - 1)/2;
            if(shouldSwap(getAt(parentIndex), node)) {
                swap(parentIndex, nodeIndex);
                heapify(node, parentIndex);
            }
        }
    }

    private void swap(int i, int j) {
        Object tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    private E getAt(int index) {
        return index <= lastIndex ? (E) elements[index] : null;
    }

    public int getSize() {
        return lastIndex + 1;
    }

    public boolean isEmpty() {
        return lastIndex == -1;
    }
}
