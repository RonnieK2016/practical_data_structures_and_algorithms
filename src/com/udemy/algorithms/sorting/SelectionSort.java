package com.udemy.algorithms.sorting;

import com.sun.istack.internal.NotNull;
import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.Arrays;

public class SelectionSort {

    private static void sort(@NotNull int[] arr) {
        int minIdx;
        for(int i = 0; i < arr.length; i++) {
            minIdx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if(minIdx != i) {
                ArrayHelper.swap(arr, i, minIdx);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = ArrayHelper.generateArray(100, 100);

        System.out.println("Input array: " + Arrays.toString(input));

        SelectionSort.sort(input);

        System.out.println("Sorted array: " + Arrays.toString(input));
    }
}
