package com.manindra.array;

import java.util.Arrays;

public class CircularArrayRotation {

    public static void main(String[] args) {

        int [] arr={1,2,3,4,5};
        int rotations=3;
        System.out.println("Original Array");
        System.out.println(Arrays.toString(arr));
        System.out.println("After "+rotations+" Rotations");
        rotateArrayCircularly(arr,rotations);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArrayCircularly(int [] arr,int rotations){
        int n=arr.length;
        rotations = rotations%n; //adjust rotations if greater than array length

        int [] temp=new int[n];

        //copy rotated array elements to the temporary array
        for (int i=0;i<n;i++){
            int newPosition=(i+rotations)%n;
            temp[newPosition]=arr[i];
        }

        //copy elements back to the original array
        System.arraycopy(temp,0,arr,0,n);
    }
}
