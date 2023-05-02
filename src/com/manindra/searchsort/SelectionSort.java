package com.manindra.searchsort;

public class SelectionSort {

    public static void main(String[] args) {
        int [] arr={5,1,9,2,10};
        selectionSort(arr);
        printArray(arr);

    }

    public static void selectionSort(int[] arr){
        int n= arr.length;
        for (int i=0;i<n-1;i++){
            int min=i;
            for (int j=i+1;j<n;j++){
                if (arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }

    }

    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
