package com.manindra.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayFrequencies {

    public static void main(String[] args) {
        int arr[] ={10,10,10,25,30,30};
        printFrequenciesSolOne(arr, arr.length);
        System.out.println("===================");
        int [] arr1={10,20,20,10,10,20,5,20};
        printFrequenciesSolTwo(arr1, arr1.length);
    }

    static void printFrequenciesSolOne(int [] arr,int n){
        int frequency=1,i=1;
        while (i<n){
            while (i<n && arr[i]==arr[i-1]){
                frequency++;
                i++;
            }
            System.out.println(arr[i-1] +" "+frequency);
            i++;
            frequency=1;
        }
        if (n==1 || arr[n-1]!=arr[n-2] )
            System.out.println(arr[n-1]+" "+1);
    }

    //time complexity : O(n2), Auxiliary space :O(n)
    static void printFrequenciesSolTwo(int [] arr,int n){
       boolean visited[] =new boolean[n];
        Arrays.fill(visited,false);
        for (int i=0;i<n;i++){
            //skip the element if already processed
            if (visited[i]==true)
                continue;

            //count frequency
            int count=1;
            for (int j=i+1;j<n;j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] +" "+count);
        }
    }
}
