package com.manindra.searching;

public class LastOccurenceIndex {

    public static void main(String[] args) {
        int [] input={5,10,10,10,20,20,20,40};
        int key=20;
        System.out.println(lastOccurenceSolIterative(input,key));
        System.out.println(lastOccurenceSolRecursive(input,0, input.length-1,key));
    }

    static int lastOccurenceSolRecursive(int [] arr,int low,int high, int key){ //tc:0(logn) AS 0(logn)
        if (low>high)
            return -1;
        int mid=(low+high)/2;
        if (key>arr[mid])
            return lastOccurenceSolRecursive(arr, mid+1, high, key);
        else if (key<arr[mid]) {
            return lastOccurenceSolRecursive(arr, low, mid-1, key);
        }else {
            if (mid== arr.length-1 || arr[mid]!=arr[mid+1])
                return mid;
            else
                return lastOccurenceSolRecursive(arr, mid+1, high, key);
        }
    }
    static int lastOccurenceSolIterative(int [] arr,int key){ //tc:0(logn)
        int low=0,high= arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]<key)
                low=mid+1;
            else if (arr[mid]>key) {
                high=mid-1;
            }else {
                if (mid == arr.length-1 || arr[mid]!=arr[mid+1])
                    return mid;
                else
                    low=mid+1;
            }
        }
        return -1;
    }
}
