package com.udemy.algorithms.datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Stack<E> {

    private Object[] elements;
    private int topIndex;

    public Stack(int capacity) {
        elements = new Object[capacity];
        topIndex = -1;
    }

    private void ensureCapacity(int newCapacity) {
        if(newCapacity == elements.length) {
            grow();
        }
    }

    private void grow() {
        elements = Arrays.copyOf(elements, (int)(elements.length*1.5));
    }

    public E push(E item) {
        ensureCapacity(topIndex + 1);
        elements[++topIndex] = item;

        return item;
    }

    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return (E) elements[topIndex];
    }

    public E pop() {
        if(isEmpty()) {
            return null;
        }

        E element = (E) elements[topIndex];
        elements[topIndex--] = null;
        return element;
    }

    public boolean isEmpty() {
        return topIndex < 0;
    }

}
