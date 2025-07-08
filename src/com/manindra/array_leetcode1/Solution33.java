package com.manindra.array_leetcode1;

public class Solution33 { //search in rotated sorted array

    public static void main(String[] args) {

        int [] arr={10,20,30,40,50,8,9};
        int key=30;
        System.out.println(searchSolOne(arr,key));
        System.out.println(searchSolTwo(arr,arr.length,key));
        System.out.println(modifiedBinarySearch(arr,key,0,arr.length-1));
    }

    static int searchSolOne(int [] arr,int key){
        for (int i=0;i<arr.length;i++)
            if (arr[i]==key)
                return i;
        return -1;
    }
    static int searchSolTwo(int [] arr,int n, int key){
        int low=0,high=n-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==key)
                return mid;
            if (arr[low]<=arr[mid]){
                if (key>=arr[low] && key<arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }else {
                if (key>arr[mid] && key<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }

    static int modifiedBinarySearch(int[] arr, int target, int left, int right) {

        // Not found
        if (left > right)
            return -1;

        // Avoid overflow, same as (left + right)/2
        int mid = left + ((right - left) / 2);
        if (arr[mid] == target)
            return mid; // Found

        // If left half is sorted
        if (arr[mid] >= arr[left]) {

            // If key is in left half
            if (arr[left] <= target && target <= arr[mid])
                return modifiedBinarySearch(arr, target, left, mid - 1);
            else
                return modifiedBinarySearch(arr, target, mid + 1, right);

        } else {
            // If right half is sorted

            // If key is in right half
            if (arr[mid] <= target && target <= arr[right])
                return modifiedBinarySearch(arr, target, mid + 1, right);
            else
                return modifiedBinarySearch(arr, target, left, mid - 1);
        }
    }
}
