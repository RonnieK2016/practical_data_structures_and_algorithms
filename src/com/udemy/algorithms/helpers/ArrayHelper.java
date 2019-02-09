package com.udemy.algorithms.helpers;

import java.util.Random;

public class ArrayHelper {

    public static int[] generateArray(int capacity, int max) {
        int[] result = new int[capacity];
        Random random = new Random();
        for(int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(max);
        }
        return result;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
