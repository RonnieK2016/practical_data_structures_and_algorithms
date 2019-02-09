package com.udemy.algorithms.tree;

public class BinarySearchTree<K extends Comparable<K>,V> {
    class Node {
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node rootNode;
    private int size;

    private void insert(Node root, K key, V value) {

        int comparisonResult = root.key.compareTo(key);

        if(comparisonResult > 0) {
            if(root.left != null) {
                insert(root.left, key, value);
            }
            else {
                root.left = new Node(key, value);
                size++;
            }
        }
        else if(comparisonResult < 0) {
            if(root.right != null) {
                insert(root.right, key, value);
            }
            else {
                root.right = new Node(key, value);
                size++;
            }
        }
        else {
            root.value = value;
        }
    }

    public void insert(K key, V value) {
        if(rootNode == null) {
            rootNode = new Node(key, value);
            size++;
        }
        else {
            insert(rootNode, key, value);
        }
    }

    private V getValue(Node root, K key) {
        if(root == null) {
            return null;
        }

        int comparisonResult = root.key.compareTo(key);
        if(comparisonResult > 0) {
            return getValue(root.left, key);
        }
        else if(comparisonResult < 0) {
            return getValue(root.right, key);
        }
        else {
            return root.value;
        }
    }

    public V getValue(K key) {
        return getValue(rootNode, key);
    }

    public int getSize() {
        return size;
    }
}
