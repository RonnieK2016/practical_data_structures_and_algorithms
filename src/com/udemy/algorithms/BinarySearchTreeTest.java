package com.udemy.algorithms;

import com.udemy.algorithms.tree.BinarySearchTree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> testTree = new BinarySearchTree<>();

        testTree.insert(10, "Ten");
        testTree.insert(67, "Sixty seven");
        testTree.insert(-10, "Minus ten");
        testTree.insert(12, "Twelve");
        testTree.insert(17, "Seventeen");
        testTree.insert(-20, "Minus twenty");

        System.out.println("Getting size " + testTree.getSize());

        System.out.println("Getting value by index -10 " + testTree.getValue(-10));

        System.out.println("Getting value by index 17 " + testTree.getValue(17));
    }

}
