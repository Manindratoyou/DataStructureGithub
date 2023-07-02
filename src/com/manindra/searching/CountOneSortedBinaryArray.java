package com.manindra.searching;

public class CountOneSortedBinaryArray {

    public static void main(String[] args) {
        int [] arr={0,0,0,1,1,1,1,1};
        System.out.println(CountOneSortedBinaryArray(arr,arr.length));
    }

    static int CountOneSortedBinaryArray(int [] arr,int n){
        int low=0,high=n-1;
        while (low<high){
            int mid=(low+high)/2;
            if (arr[mid]==0)
                low=mid+1;
            else{
                if (mid==0 || arr[mid-1]!=arr[mid])
                    return n-mid;
                else
                    high=mid-1;
            }
        }
        return 0;
    }
}
