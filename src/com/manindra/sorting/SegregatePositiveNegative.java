package com.manindra.sorting;

import java.util.Arrays;

public class SegregatePositiveNegative {

    public static void main(String[] args) {

        int [] arr={13,-12,18,-10};
        //segregatePositiveNegative(arr);
        segregatePositiveNegativesolTwo(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void segregatePositiveNegative(int [] arr){
        int [] temp=new int[arr.length];
        int i=0;
        for (int j=0;j< arr.length;j++)
            if (arr[j]<0)
                temp[i++]=arr[j];
        for (int j=0;j< arr.length;j++)
            if (arr[j]>0)
                temp[i++]=arr[j];
        //copy temp array element to original array
        for (int j=0;j< arr.length;j++)
            arr[j]=temp[j];
    }
    static void segregatePositiveNegativesolTwo(int [] arr){
       int i=-1,j= arr.length;
       while (true){
           do {
               i++;
           }while (arr[i]<0);
           do {
               j--;
           }while (arr[j]>=0);
           if (i>=j)
               return;
           //swap arr[i] with arr[j]
           int temp=arr[i];
           arr[i]=arr[j];
           arr[j]=temp;
       }
    }
}
