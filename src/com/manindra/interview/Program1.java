package com.manindra.interview;

/*
You are a manager of a logistic company, and you are responsible for optimizing the delivery routes for your drivers.
Each driver is assigned a specific route represented by an array arr of length n, where arr[i] represents the time it
takes for the driver to travel to the i-th delivery point.

Write a function/method in Java named optimizeRoute that takes an array of delivery times arr and its length n as
parameters and returns the index (1-based) where the sum of travel times to the left of the index is equal to the sum
of travel times to the right of the index. If no such index exists, return -1.
 */
public class Program1 {

    public static void main(String[] args) {

        long[] arr = {2, 3, 1, 4, 2, 2};
        long[] arr1 = {1, 7, 3, 6, 5, 6};
        int n = 6;
        int result = optimizeRoute(arr, n);
        System.out.println(result); // Output: 3

    }

    public static int optimizeRoute(long [] arr,int n){
        long [] prefixSum=new long[n];
        long [] suffixSum=new long[n];

        prefixSum[0]=arr[0];
        suffixSum[n-1]=arr[n-1];

        for (int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        for (int i=n-2;i>=0;i--){
            suffixSum[i]=suffixSum[i+1]+arr[i];
        }

        for (int i=0;i< n;i++){
            if (prefixSum[i]==suffixSum[i])
                return i+1;
        }

        return -1;

    }


}
