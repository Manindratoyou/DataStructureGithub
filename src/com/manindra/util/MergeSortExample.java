package com.manindra.util;

import java.util.Arrays;

public class MergeSortExample {

    public static void main(String[] args) {

        int [] array={10,5,30,15,7};
        int left=0;
        int right= array.length-1;

        System.out.println("Original Array " + Arrays.toString(array));

        mergeSort(array,left,right);

        System.out.println("Sorted Array " + Arrays.toString(array));
    }

    static void mergeSort(int [] arr,int low,int high){
        if (high>low){ //if (low<high) {
          //find the middle point of the array
          int mid=low+(high-low)/2;

          //recursive sort the first and second halves
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);

            //merge the sorted halves
            merge(arr,low,mid,high);
        }
    }

    //merge two subarray of arr[]
    //first subarray is arr[low..mid]
    //second subarray is arr[mid+1..high]

    static void merge(int [] arr,int low,int mid,int high){
        //calculate length of two subarray
        int leftSubArrayLength=mid-low+1;
        int rightSubArrayLength=high-mid;

        //create temporary arrays
        int [] leftArray=new int[leftSubArrayLength];
        int [] rightArray=new int[rightSubArrayLength];

        //copy data to temporary arrays leftArray[] and rightArray[]
        for (int i=0;i<leftSubArrayLength;i++)
            leftArray[i]=arr[low+i];
        for (int j=0;j<rightSubArrayLength;j++)
            rightArray[j]=arr[mid+1+j];

        //merge the temporary array

        //initial indices of first and second subarrays
        int i=0 ,j=0;
        //initial index of merged subarray array[]
        int k=low;

        while (i<leftSubArrayLength && j<rightSubArrayLength){
            if (leftArray[i]<rightArray[j]){
                //if the element in the left array is smaller ,copy it to original array
                arr[k++]=leftArray[i++];
            }else {
                //if the element in the right array is smaller ,copy it to original array
                arr[k++]=rightArray[j++];
            }
        }
        //copy the remaining elements of leftArray[] ,if there are any
        while (i<leftSubArrayLength) arr[k++]=leftArray[i++];
        //copy the remaining element of rightArray[] ,if there are any
        while (j<rightSubArrayLength) arr[k++]=rightArray[j++];

    }
}
