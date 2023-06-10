package com.manindra.sorting;

import java.util.Arrays;

public class MergeFunctionOfMergeSort {

    public static void main(String[] args) {
        int [] arr={10,15,20,40,8,11,55};
        merge(arr,0,3,6);
        System.out.println(Arrays.toString(arr));
    }

    static void merge(int [] arr,int low,int mid,int high){
        //1st part
        int n1=mid-low+1,n2=high-mid;
        int [] left =new int[n1];
        int [] right=new int[n2];
        for (int i=0;i<n1;i++)
            left[i]=arr[low+i];
        for (int i=0;i<n2;i++)
            right[i]=arr[mid+i+1];
        //2nd part
        int i=0,j=0,k=low;
        while (i<n1 && j<n2){
            if (left[i]<=right[j]){
                arr[k]=left[i];
                i++;
                k++;
            }else {
                arr[k]=right[j];
                k++;
                j++;
            }
        }
        while (i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }

    }
}
