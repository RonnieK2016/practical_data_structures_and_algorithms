package com.udemy.algorithms.sorting;

import com.sun.istack.internal.NotNull;
import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.Arrays;

public class QuickSort {

    private static void sort(@NotNull int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = partition(arr, low, high);
        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIdx = (low + high)/2;
        int pivot = arr[pivotIdx];

        ArrayHelper.swap(arr, pivotIdx, high);

        int i = low;

        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                ArrayHelper.swap(arr, i, j);
                i++;
            }
        }
        ArrayHelper.swap(arr, i, high);

        return i;
    }


    public static void main(String[] args) {
        int[] input = ArrayHelper.generateArray(100, 100);

        System.out.println("Input array: " + Arrays.toString(input));

        QuickSort.sort(input, 0, input.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(input));
    }
}
