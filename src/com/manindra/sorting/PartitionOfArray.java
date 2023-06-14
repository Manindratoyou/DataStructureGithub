package com.manindra.sorting;

import java.util.Arrays;

//Naive
public class PartitionOfArray {

    public static void main(String[] args) {
        int [] arr={5,13,6,9,12,11,8};
        naivePartition(arr,0, arr.length-1, 6);
        System.out.println(Arrays.toString(arr));
    }

    //time complexity 0(n) ,Auxiliary space 0(n)
    static void naivePartition(int [] arr,int low,int high,int partitionIndex){

        //create a temp array to hold all the above element
        int [] temp=new int[high-low+1];

        int index=0;
        for (int i=low;i<=high;i++){
            if (arr[i]<=arr[partitionIndex]){
                temp[index]=arr[i];
                index++;
            }
        }
        for (int i=low;i<=high;i++){
            if (arr[i]>arr[partitionIndex]){
                temp[index]=arr[i];
                index++;
            }
        }
        //copy temp [] element to original array
        for (int i=low;i<=high;i++){ //i=0,temp[i]
            arr[i]=temp[i-low];
        }
    }
}
