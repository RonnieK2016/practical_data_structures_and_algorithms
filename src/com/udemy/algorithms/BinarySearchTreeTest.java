package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.BinarySearchTree;

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

        System.out.println("Getting minimum value - " + testTree.getMinValue());

        System.out.println("Getting maximum value - " + testTree.getMaxValue());

        System.out.println("Getting value by index -10 " + testTree.getValue(-10));

        System.out.println("Getting value by index 17 " + testTree.getValue(17));

        System.out.println("Deleting node " + testTree.deleteKey(12));

        System.out.println("Checking that node 12 is gone -  " + testTree.getValue(12));

        System.out.println("Size of tree after deletion " + testTree.getSize());

        System.out.println("Printing tree " + testTree.printTree());
    }

}
