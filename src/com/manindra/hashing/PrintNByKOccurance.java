package com.manindra.hashing;

import java.util.Arrays;

public class PrintNByKOccurance {

    public static void main(String[] args) {

        int [] arr={30,10,20,20,10,20,30,30};//how many number appear more than n/k times
        int k=4;
        printNBYK(arr, arr.length, k);
    }

    static void printNBYK(int [] arr,int n,int k){
        Arrays.sort(arr);
        int i=1,count=1;
        while (i<n){
            while (i<n && arr[i]==arr[i-1]){
                count++;
                i++;
            }
            if (count>n/k)
                System.out.println(arr[i-1]);
            count=1;
            i++;
        }
    }
}
