package com.manindra.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int [] arr={10,5,8,20,2,18};
        //selectionSortSolOne(arr,arr.length);
        selectionSortSolTwo(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSortSolOne(int [] arr,int n){
        int [] temp=new int[n];
        for (int i=0;i<n;i++){
            int min_index=0;
            for (int j=1;j<n;j++)
                if (arr[j]<arr[min_index])
                    min_index=j;
            temp[i]=arr[min_index];
            arr[min_index]=Integer.MAX_VALUE;
        }
        for (int i=0;i<n;i++)
            arr[i]=temp[i];
    }

    //in place implementation
    static void selectionSortSolTwo(int [] arr,int n){
        for (int i=0;i<n-1;i++){
            int min_index=i;
            for (int j=i+1;j<n;j++){
                if (arr[j]<arr[min_index]) {
                    min_index = j;
                    //swap ar[min_index] , arr[j]
                    int temp=arr[min_index];
                    arr[min_index]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }
}
