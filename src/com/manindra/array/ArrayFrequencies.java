package com.manindra.array;

public class ArrayFrequencies {

    public static void main(String[] args) {
        int arr[] ={10,10,10,25,30,30};
        printFrequenciesSolOne(arr, arr.length);
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
}
