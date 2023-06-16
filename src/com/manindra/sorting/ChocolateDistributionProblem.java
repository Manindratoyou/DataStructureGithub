package com.manindra.sorting;

import java.util.Arrays;

public class ChocolateDistributionProblem {

    public static void main(String[] args) {
        int [] arr={7,3,2,4,9,12,56};
        int m=3;
        System.out.println(minDiff(arr,m));
    }

    static int minDiff(int [] arr,int m){ //tc 0(nlogn)
        if (m> arr.length)
            return -1;
        Arrays.sort(arr);
        int result=arr[m-1]-arr[0];
        for (int i=1;(i+m-1)< arr.length;i++){
            result=Math.min(result,arr[i+m-1]-arr[i]);
        }
        return result;
    }

    //for two
    static int chocolateDistributionProblem(int [] arr){
        Arrays.sort(arr);
        int result=Integer.MAX_VALUE;
        for (int i=2;i< arr.length;i++){
            result=Math.min(result,Math.abs(arr[i]-arr[i-2]));
        }
        return result;
    }
}
