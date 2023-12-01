package com.manindra.leetcodeMedium;

public class Solution53 { //max sum sub array

    public static void main(String[] args) {
        int [] arr={2,3,-8,7,-1,2,3};
        System.out.println(maxSumSubArray(arr,arr.length));
    }

    static int maxSumSubArray(int [] arr, int n){
        int result=arr[0];
        int maxEnding=arr[0];
        for (int i=1;i<n;i++){
            maxEnding=Math.max(maxEnding+arr[i],arr[i]);
            result=Math.max(result,maxEnding);
        }
        return result;
    }
}
