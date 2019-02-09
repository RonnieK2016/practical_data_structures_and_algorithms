package com.udemy.algorithms.sorting;

import com.sun.istack.internal.NotNull;
import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.Arrays;

public class MergeSort {

    private static void sort(@NotNull int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int mid = (low + high)/2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] tempArr = new int[(high - low) + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                tempArr[k++] = arr[i];
                i++;
            }
            else {
                tempArr[k++] = arr[j];
                j++;
            }
        }

        //merging rest of arrays
        while(i<=mid) {
            tempArr[k++] = arr[i];
            i++;
        }

        while(j <= high) {
            tempArr[k++] = arr[j];
            j++;
        }

        //merging temp array into main
        k = 0;
        i = low;
        while(i <= high) {
            arr[i++] = tempArr[k++];
        }

    }


    public static void main(String[] args) {
        int[] input = ArrayHelper.generateArray(100, 100);

        System.out.println("Input array: " + Arrays.toString(input));

        MergeSort.sort(input, 0, input.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(input));
    }

}
