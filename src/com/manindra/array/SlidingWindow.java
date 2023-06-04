package com.manindra.array;

public class SlidingWindow {

    public static void main(String[] args) {

        int [] arr={1,8,30,-5,20,7};
        System.out.println(maxSumSolOne(arr, arr.length, 3));
        System.out.println(maxSumSolTwo(arr, arr.length, 3));
    }
    //maximum sum of k consecutive element
    static int maxSumSolOne(int [] arr,int n,int k){
        int result=Integer.MIN_VALUE;
        for (int i=0;i+k-1<n;i++){
            int current=0;
            for (int j=0;j<k;j++)
                current+=arr[i+j];
            result=Math.max(result,current);
        }
        return result;
    }
    static int maxSumSolTwo(int [] arr,int n,int k){ //O(n) tc O(1) as
        int current=0;
        for (int i=0;i<k;i++)
            current+=arr[i];
        int result=current;
        for (int i=k;i<n;i++){
            current=current+arr[i]-arr[i-k];
            result=Math.max(result,current);
        }
        return result;
    }
}
