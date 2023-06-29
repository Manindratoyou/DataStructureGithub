package com.manindra.searching;

public class CountOccurenceArray {

    public static void main(String[] args) {
        int [] arr={10,20,20,20,30,30};
        int key=20;
        System.out.println(countOccurence(arr,key));
    }
    static int countOccurence(int [] arr,int key){
        int first=firstOccurenceSolThreeIterative(arr, key);
        if (first==-1)
            return 0;
        else
            return (lastOccurenceSolIterative(arr,key)-first+1);
    }

    static int firstOccurenceSolThreeIterative(int [] arr,int key){ //tc:0(logn)
        int low=0,high= arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (arr[mid]>key)
                high=mid-1;
            else if (arr[mid]<key) {
                low=mid+1;
            }else {
                if (mid==0 || arr[mid-1]!=arr[mid])
                    return mid;
                else
                    high=mid-1;
            }
        }
        return -1;
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
