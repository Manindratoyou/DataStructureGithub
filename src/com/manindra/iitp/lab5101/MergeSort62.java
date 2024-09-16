package com.manindra.iitp.lab5101;

public class MergeSort62 {

    public static void main(String[] args) {
        // Test case 1: Random integers
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Test case 1: Sorted array:");
        mergeSort(arr1, 0, arr1.length - 1);
        printArray(arr1); // Expected output: 3 9 10 27 38 43 82

        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Test case 2: Sorted array:");
        mergeSort(arr2, 0, arr2.length - 1);
        printArray(arr2); // Expected output: 1 2 3 4 5

        // Test case 3: Array with duplicate elements
        int[] arr3 = {5, 1, 1, 3, 2, 2, 4};
        System.out.println("Test case 3: Sorted array:");
        mergeSort(arr3, 0, arr3.length - 1);
        printArray(arr3); // Expected output: 1 1 2 2 3 4 5

        // Test case 4: Single element array
        int[] arr4 = {10};
        System.out.println("Test case 4: Sorted array:");
        mergeSort(arr4, 0, arr4.length - 1);
        printArray(arr4); // Expected output: 10

        // Test case 5: All elements are the same
        int[] arr5 = {7, 7, 7, 7, 7};
        System.out.println("Test case 5: Sorted array:");
        mergeSort(arr5, 0, arr5.length - 1);
        printArray(arr5); // Expected output: 7 7 7 7 7
    }

    // Main merge sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
