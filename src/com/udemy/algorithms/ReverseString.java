package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.Stack;

public class ReverseString {

    public static void reverseString(String inputString) {
        Stack<Character> stack = new Stack<>(10);

        char[] arr = inputString.toCharArray();

        for(char ch : arr) {
            stack.push(ch);
        }

        StringBuilder resultStr = new StringBuilder();
        while(!stack.isEmpty()) {
            resultStr.append(stack.pop());
        }

        System.out.println("Result string - " + resultStr.toString());
    }

    public static void main(String[] args) {
        reverseString("We need to reverse this string using stacks!!!");
    }
}
