package com.manindra.searching;

public class FirstOccuranceIndex {

    public static void main(String[] args) {
        int[] input = {1, 10, 10, 10, 20, 20, 40};
        int key = 20;
        System.out.println(firstOccurenceSolOne(input, key));
        System.out.println(firstOccurenceSolThreeIterative(input, key));
        System.out.println(firstOccurenceSolTwoRecursive(input, 0, input.length - 1, key));
    }

    static int firstOccurenceSolOne(int[] arr, int key) { //tc:0(n) AS:0(1)
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }

    static int firstOccurenceSolTwoRecursive(int[] arr, int low, int high, int key) { //tc:0(logn) AS 0(logn)
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (key > arr[mid])
            return firstOccurenceSolTwoRecursive(arr, mid + 1, high, key);
        else if (key < arr[mid]) {
            return firstOccurenceSolTwoRecursive(arr, low, mid - 1, key);
        } else {
            if (mid == 0 || arr[mid - 1] != arr[mid])
                return mid;
            else
                return firstOccurenceSolTwoRecursive(arr, low, mid - 1, key);
        }
    }

    static int firstOccurenceSolThreeIterative(int[] arr, int key) { //tc:0(logn)
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key)
                high = mid - 1;
            else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
