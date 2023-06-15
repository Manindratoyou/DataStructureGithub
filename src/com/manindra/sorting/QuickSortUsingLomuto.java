package com.manindra.sorting;

import java.util.Arrays;

public class QuickSortUsingLomuto {

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 4, 20, 7, 10};
        quickSortUsingLomuto(arr, 0 ,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSortUsingLomuto(int [] arr ,int low ,int high){
        if (low<high){
            int partition=lomutoPartition(arr ,low ,high);
            quickSortUsingLomuto(arr, low, partition-1);
            quickSortUsingLomuto(arr ,partition+1 ,high);
        }
    }

    static int lomutoPartition(int [] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for (int j=low;j<=high-1;j++){
            if (arr[j]<pivot){
                i++;
                //swap arr[i] with arr[j]
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //swap arr[i+1] with arr[high] for pivot element
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;// return pivot element
    }
}
