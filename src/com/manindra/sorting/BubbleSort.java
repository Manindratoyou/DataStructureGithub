package com.manindra.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
     int [] arr={10,8,20,5};
     //bubbleSortSolOne(arr, arr.length);
        bubbleSortSolTwo(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSortSolOne(int [] arr,int n){
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                if (arr[j]>arr[j+1]) {
                    //swap arr[j],arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    static void bubbleSortSolTwo(int [] arr,int n){
        for (int i=0;i<n-1;i++){
            boolean isSwapped=false;
            for (int j=0;j<n-i-1;j++){
                if (arr[j]>arr[j+1]) {
                    //swap arr[j],arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;

                    isSwapped=true;
                }
            }
            if (isSwapped==false)
                break;
        }
    }
}
