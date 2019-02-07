package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.Stack;

public class ReverseString {

    public static void main(String[] args) {
        String testString = "We need to reverse this string using stacks!!!";

        Stack<Character> stack = new Stack<>(10);

        char[] arr = testString.toCharArray();

        for(char ch : arr) {
            stack.push(ch);
        }

        StringBuilder resultStr = new StringBuilder();
        while(!stack.isEmpty()) {
            resultStr.append(stack.pop());
        }

        System.out.printf("Result string - " + resultStr.toString());
    }
}
