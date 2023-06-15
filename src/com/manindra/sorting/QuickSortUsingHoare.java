package com.manindra.sorting;

import java.util.Arrays;

public class QuickSortUsingHoare {
    public static void main(String[] args) {
        int [] arr={8,4,7,9,3,10,5};
        quickSortUsingHoare(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSortUsingHoare(int [] arr ,int low ,int high){
        if (low<high){
            int partition=hoarePartition(arr ,low ,high);
            quickSortUsingHoare(arr, low, partition);
            quickSortUsingHoare(arr ,partition+1 ,high);
        }
    }

    static int hoarePartition(int [] arr, int low, int high){
        int pivot=arr[low];
        int i=low-1,j=high+1;
        while (true){
            do {
                i++;
            }while (arr[i]<pivot);
            do {
                j--;
            }while (arr[j]>pivot);
            if (i>=j) return j;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }//j=3
    }//1 3 2 4 8 7 5 10 ,pivot is not at correct place
}
