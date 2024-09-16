package com.manindra.iitp.lab5101;

public class QuickSort50 {

    public static void main(String[] args) {
        // Test case 1: Random integers
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Test case 1: Sorted array:");
        quickSort(arr1, 0, arr1.length - 1);
        printArray(arr1); // Expected output: 3 9 10 27 38 43 82

        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Test case 2: Sorted array:");
        quickSort(arr2, 0, arr2.length - 1);
        printArray(arr2); // Expected output: 1 2 3 4 5

        // Test case 3: Array with duplicate elements
        int[] arr3 = {5, 1, 1, 3, 2, 2, 4};
        System.out.println("Test case 3: Sorted array:");
        quickSort(arr3, 0, arr3.length - 1);
        printArray(arr3); // Expected output: 1 1 2 2 3 4 5

        // Test case 4: Single element array
        int[] arr4 = {10};
        System.out.println("Test case 4: Sorted array:");
        quickSort(arr4, 0, arr4.length - 1);
        printArray(arr4); // Expected output: 10

        // Test case 5: All elements are the same
        int[] arr5 = {7, 7, 7, 7, 7};
        System.out.println("Test case 5: Sorted array:");
        quickSort(arr5, 0, arr5.length - 1);
        printArray(arr5); // Expected output: 7 7 7 7 7
    }

    // Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to take the last element as the pivot, place it at the right position in the sorted array
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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
