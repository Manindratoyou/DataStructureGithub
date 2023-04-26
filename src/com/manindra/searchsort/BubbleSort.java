package com.manindra.searchsort;

public class BubbleSort {

    public static void main(String[] args) {

        int [] arr={5,1,2,9,10};
        System.out.println("before sorting");
        printArray(arr);
        System.out.println("After sorting");
        bubbleSort(arr);
        printArray(arr);
    }

    static void bubbleSort(int[] arr){
        int n= arr.length;
        boolean isSwapped;
        for (int i=0;i<n-1;i++) {
            isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false) {
                break;
            }
        }
    }
    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

}
