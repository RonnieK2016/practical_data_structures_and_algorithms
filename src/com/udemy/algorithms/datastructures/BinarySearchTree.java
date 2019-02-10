package com.udemy.algorithms.datastructures;

import java.util.*;
import java.util.Queue;

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

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
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

    private Node getNodeByKey(Node root, K key) {
        if(root == null) {
            return null;
        }

        int comparisonResult = root.key.compareTo(key);
        if(comparisonResult > 0) {
            return getNodeByKey(root.left, key);
        }
        else if(comparisonResult < 0) {
            return getNodeByKey(root.right, key);
        }
        else {
            return root;
        }
    }

    public V getValue(K key) {
        Node nodeAt = getNodeByKey(rootNode, key);
        return nodeAt != null ? nodeAt.value : null;
    }

    private void swapNode(Node rootNode, Node find, Node replace) {
        if(rootNode.left == find) {
            rootNode.left = replace;
        }
        else {
            rootNode.right = replace;
        }
    }

    public V deleteKey(K key) {
        if(rootNode == null) {
            return null;
        }

        Node parentNode = null;
        Node searchNode = null;
        Node c = rootNode;
        while(c != null) {
            int comparison = c.key.compareTo(key);
            if(comparison > 0) {
                parentNode = c;
                c = c.left;
            }
            else if(comparison < 0) {
                parentNode = c;
                c = c.right;
            }
            else {
                searchNode = c;
                break;
            }
        }

        V value = null;
        if(searchNode != null) {

            value = searchNode.value;

            //case when either no children or only right
            if(searchNode.right == null) {
                //head node;
                if(parentNode == null) {
                    rootNode = searchNode.left;
                }
                else {
                    swapNode(parentNode, searchNode, searchNode.left);
                    searchNode.left = null;
                }
            }
            // case when right child doesn't have left child
            else if(searchNode.right.left == null) {
                //head node;
                if(parentNode == null) {
                    rootNode = searchNode.right;
                }
                else {
                    swapNode(parentNode, searchNode, searchNode.right);
                    searchNode.right = null;
                }
            }
            //case when there are two child
            else {
                //find leftmost child
                Node leftMost = searchNode.right.left;
                Node leftMostParent = searchNode.right;
                while(leftMost.left != null) {
                    leftMostParent = leftMost;
                    leftMost = leftMost.left;
                }

                //moving right child of leftmost node to its parent
                leftMostParent.left = leftMost.right;

                //moving children of searchNode under the leftmost node
                leftMost.left = searchNode.left;
                leftMost.right = searchNode.right;

                searchNode.left = null;
                searchNode.right = null;

                //moving leftMost child into position of searchNode
                //rootNode case
                if(parentNode == null) {
                    rootNode = leftMost;
                }
                else {
                    swapNode(rootNode, searchNode, leftMost);
                }
            }
        }

        size--;

        return value;
    }


    public int getSize() {
        return size;
    }

    public V getMinValue() {
        if(rootNode == null) {
            return null;
        }

        Node min = rootNode;

        while(min.left != null) {
            min = min.left;
        }

        return min.value;
    }

    public V getMaxValue() {
        if(rootNode == null) {
            return null;
        }

        Node max = rootNode;

        while(max.right != null) {
            max = max.right;
        }

        return max.value;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "rootNode=" + rootNode +
                '}';
    }


    public String printTree() {
        if(rootNode == null) {
            return "";
        }

        List<List<K>> levels = new ArrayList<>();
        levels.add(Collections.singletonList(rootNode.key));

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> level = new LinkedList<>();
        Node emptyNode = new Node(null, null);

        queue.offer(rootNode);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.left != null) {
                level.add(node.left);
            }
            else {
                level.add(emptyNode);
            }

            if(node.right != null) {
                level.add(node.right);
            }
            else {
                level.add(emptyNode);
            }

            if(queue.isEmpty() && !level.isEmpty()) {
                List<K> keys = new ArrayList<>();
                for(Node n : level) {
                    keys.add(n.key);
                    if(n.key != null) {
                        queue.add(n);
                    }
                }

                if(!queue.isEmpty()) {
                    levels.add(keys);
                }

                level.clear();
            }
        }

        int maxLevel = levels.size();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < levels.size(); i++) {

            result.append("\r\n");

            int floor = maxLevel - i;
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            appendWhiteSpaces(firstSpaces, result);

            for (K key : levels.get(i)) {
                if(key != null) {
                    result.append(key);
                }
                else {
                    result.append("--");
                }

                appendWhiteSpaces(betweenSpaces, result);
            }
        }

        return result.toString();
    }

    private void appendWhiteSpaces(int count, StringBuilder output) {
        for (int i = 0; i < count; i++) {
            output.append(" ");
        }
    }
}
