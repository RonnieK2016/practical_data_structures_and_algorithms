package com.udemy.algorithms.searching;

import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.Arrays;

public class BinarySearch {

    private static int searchRecursive(int[] array, int value, int low, int high) {
        if(low >= high) {
            return -1;
        }

        int mid = (low + high)/2;
        if(array[mid] > value) {
            return searchRecursive(array, value, low, mid - 1);
        }
        else if(array[mid] < value) {
            return searchRecursive(array, value, mid + 1, high);
        }
        else {
            return mid;
        }
    }

    private static int search(int[] array, int value) {
        int low = 0;
        int high = array.length;

        while(low < high) {
            int mid = (low + high)/2;

            if(array[mid] < value) {
                low = mid + 1;
            }
            else if(array[mid] > value) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] input  = ArrayHelper.generateArray(100, 5000);

        Arrays.sort(input);

        System.out.println("Sorted array: " + Arrays.toString(input));

        int inputElem = input[37];

        System.out.println("Index of searched element " + BinarySearch.search(input, inputElem));
        System.out.println("Index of searched element recursive " + BinarySearch.searchRecursive(input, inputElem,
                0, input.length));
    }
}
