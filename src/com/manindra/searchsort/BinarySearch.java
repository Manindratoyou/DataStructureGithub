package com.manindra.searchsort;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr={1,10,20,47,59,65,75,88,99};
        System.out.println(binarySearch(arr,65));
    }

    static int binarySearch(int[] arr, int key) {

        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(high+low)/2;
            if (arr[mid]==key)
                return mid;
            if (key<arr[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
