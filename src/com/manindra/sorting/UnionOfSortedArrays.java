package com.manindra.sorting;

public class UnionOfSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 5, 6, 7};

        int[] unionArray = findUnion(arr1, arr2);

        System.out.println("Array 1: ");
        printArray(arr1);
        System.out.println("\nArray 2: ");
        printArray(arr2);
        System.out.println("\nUnion of the two arrays: ");
        printArray(unionArray);
    }

    public static int[] findUnion(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] union = new int[n1 + n2]; // Maximum possible size.
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                union[k++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                union[k++] = arr2[j++];
            } else { // Equal elements, add only once
                union[k++] = arr1[i++];
                j++;
            }
        }

        // Copy remaining elements of the first array, if any
        while (i < n1) {
            union[k++] = arr1[i++];
        }

        // Copy remaining elements of the second array, if any
        while (j < n2) {
            union[k++] = arr2[j++];
        }

        // Create a new array with the exact size of the union (remove extra zeros)
        int[] result = new int[k];
        System.arraycopy(union, 0, result, 0, k);
        return result;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}

