package com.manindra.sorting;

public class PartitionOfArrayLomuto {

    public static void main(String[] args) {
        int [] arr={5,13,6,9,12,11,8};
        int pivotIndex=lomutoPartition(arr,0,arr.length-1);
        System.out.println(pivotIndex);
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
