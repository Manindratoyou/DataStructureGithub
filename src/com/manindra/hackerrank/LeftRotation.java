package com.manindra.hackerrank;

import java.util.Arrays;

public class LeftRotation {

    public static void main(String[] args) {

        int [] arr={1,2,3,4,5,6,7}; int k=3;
        //leftRotate(arr,k);
        leftRotateUsingReverse(arr,k);
        System.out.println(Arrays.toString(arr));
    }

    static void leftRotate(int [] arr,int k){
        k%= arr.length;
        int [] temp=new int[k];

        //store the first k element in a temp array
        for (int i=0;i<temp.length;i++){
            temp[i]=arr[i];
        }
        //shift rest of the array
        for (int i=0;i< arr.length-k;i++){
            arr[i]=arr[i+k];
        }

        //store back the k elements
        for (int i= arr.length-k;i<arr.length;i++){
            arr[i]=temp[i-k-1];
        }
    }

    //helper function to reverse an array from start index to end index
    static void reverse(int [] nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    static void leftRotateUsingReverse(int [] arr,int k){
        k%= arr.length;

        //reverse all numbers
        reverse(arr,0, arr.length-1);

        //reverse first arr.length-k numbers
        reverse(arr,0,arr.length-k-1);

        //reverse last k numbers
        reverse(arr, arr.length-k, arr.length-1);

    }


}
