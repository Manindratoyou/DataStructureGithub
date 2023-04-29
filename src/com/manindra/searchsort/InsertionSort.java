package com.manindra.searchsort;

public class InsertionSort {

    public static void main(String[] args) {
        int [] arr={5,1,9,2,10};
        insertionSort(arr);
        printArray(arr);

    }

    public static void insertionSort(int[] n){
        for (int i=0;i<n.length;i++){
            int temp=n[i];
            int j=i-1;
            while (j>0 && n[j]>temp){
                n[j+1]=n[j];
                j=j-1;
            }
            n[j+1]=temp;
        }
    }

    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
