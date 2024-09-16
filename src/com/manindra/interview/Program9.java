package com.manindra.interview;

import java.util.Arrays;

public class Program9 {

    public static void main(String[] args) {

        int [] arr={100,80,60,70,60,75,85};
        int result []= findNextGreaterToLeft(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] findNextGreaterToLeft(int[] array) {
        int n = array.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = findGreaterToLeft(array, i);
        }

        return result;
    }

    static int findGreaterToLeft(int[] array, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (array[i] > array[index]) {
                return array[i];
            }
        }
        return -1; // No greater element to the left
    }
}
