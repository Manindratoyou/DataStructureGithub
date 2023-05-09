package com.manindra.searchsort;

public class RearrangeSortedArray {

    public static void main(String[] args) {

        int [] arr={1,2,3,4,5,6,7,8};
        printArray(arr);
        arrangeMaxMin(arr);
        printArray(arr);

    }
    public static void arrangeMaxMin(int [] arr){
        int maxIdx=arr.length-1;
        int minIdx=0;
        int max=arr[maxIdx]+1;
        for (int i=0;i< arr.length;i++){
            if (i%2==0){
                arr[i]=arr[i]+(arr[maxIdx]%max)*max;
                maxIdx--;
            }else {
                arr[i]=arr[i]+(arr[minIdx]%max)*max;
                minIdx++;
            }
        }
        for (int i=0;i<arr.length;i++){
            arr[i]=arr[i]/max;
        }
    }
    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
