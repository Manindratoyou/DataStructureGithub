package com.manindra.searchsort;

public class ThreeNumberSort {

    public static void main(String[] args) {
        int [] arr={0,0,1,2,0,1,2};
        printArray(arr);
        sortZeroOneTwo(arr);
        printArray(arr);
    }

    public static void sortZeroOneTwo(int[] arr){
        int i=0;int j=0;int k= arr.length-1;
        while (i<=k){
            if (arr[i]==0){
                swap(arr,i,j);
                i++;j++;
            } else if (arr[i]==1) {
                i++;
            } else if (arr[i]==2) {
                swap(arr,i,k);
                k--;
            }
        }
    }
    public static void swap(int [] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
