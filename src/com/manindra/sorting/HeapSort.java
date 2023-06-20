package com.manindra.sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int [] arr={12,11,13,5,6,7};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int [] arr,int n){
        buildheap(arr,n);
        for (int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr, i, 0);
        }
    }
    static void buildheap(int [] arr,int n){
        for (int i=n / 2 - 1;i>=0;i--)
            heapify(arr, n, i);
    }
    static void heapify(int [] arr, int n, int i){
        int largest=i;
        int low=2*i+1;
        int high=2*i+2;
        if (low<n && arr[low]>arr[largest])
            largest=low;
        if (high<n && arr[high]>arr[largest])
            largest=high;
        if (largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;

            heapify(arr, n ,largest);
        }
    }
}
