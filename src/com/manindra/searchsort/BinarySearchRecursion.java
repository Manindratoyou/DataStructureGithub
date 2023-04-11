package com.manindra.searchsort;

public class BinarySearchRecursion {

    public static void main(String[] args) {

        int [] arr={23,43,45,62,87,98};
        int low=0;
        int high= arr.length;

        int result=binarySearchRec(arr,98,low,high);

        if (result==-1)
            System.out.println("Key Not Present" );
        else
            System.out.println("key found at index " +result);
    }

    public static int binarySearchRec(int[] arr, int key,int low,int high) {

        if ( high==-1 || low==arr.length) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;

        else if (key > arr[mid]) {
            return binarySearchRec(arr, key, mid + 1, high);
        } else {
            return binarySearchRec(arr, key, low, high - 1);
        }
    }
}
