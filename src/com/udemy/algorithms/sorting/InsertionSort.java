package com.udemy.algorithms.sorting;

import com.sun.istack.internal.NotNull;
import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.Arrays;

public class InsertionSort {

    private static void sort(@NotNull int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while(j > 0 && arr[j] < arr[j - 1]) {
                ArrayHelper.swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = ArrayHelper.generateArray(100, 100);

        System.out.println("Input array: " + Arrays.toString(input));

        InsertionSort.sort(input);

        System.out.println("Sorted array: " + Arrays.toString(input));
    }
}
