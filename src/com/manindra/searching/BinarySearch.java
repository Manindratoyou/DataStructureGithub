package com.manindra.searching;

public class BinarySearch {

    public static void main(String[] args) {
        int [] arr={20,40,50,70,90,120,240};
        int key=50;
        System.out.println(binarySearchIterative(arr,key));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,key));
    }

    static int binarySearchIterative(int [] arr,int key){ //tc 0(logn)
        int low=0,high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==key)
                return mid;
            else if (arr[mid]>key) {
                high=mid-1;
            }else
                low=mid+1;
        }
        return -1;
    }

    static int binarySearchRecursive(int [] arr,int low,int high,int key){ //tc 0(logn) as:Q(logn) as it required extra space
        if (low>high)
            return -1;
        int mid=(low+high)/2;
        if (arr[mid]==key)
            return mid;
        else if (arr[mid]>key) {
            return binarySearchRecursive(arr, low, mid-1, key);
        }
        else
            return binarySearchRecursive(arr, mid+1, high, key);
    }
}
