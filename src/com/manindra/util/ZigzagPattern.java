package com.manindra.util;

public class ZigzagPattern {

    static void printZigzagPattern(int[] arr, int n) {
        boolean flag = true;

        for (int i = 0; i < n - 1; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            flag = !flag;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 7, 8, 6, 2, 1 };
        int n = arr.length;

        System.out.println("Input array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Output array (Zigzag pattern):");
        printZigzagPattern(arr, n);
    }
}
