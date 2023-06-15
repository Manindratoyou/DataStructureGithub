package com.manindra.sorting;

public class PartitionOfArrayHoare {

    public static void main(String[] args) {

        int [] arr={5,3,8,4,2,7,1,10};
        hoarePartition(arr,0,arr.length-1);
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
