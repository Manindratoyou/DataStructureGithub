package com.manindra.searchsort;

public class MergeTwoSortedArray {

    public static void main(String[] args) {

        int [] arr1={2,5,7};
        int [] arr2={3,4,9};
        printArray(arr1);
        printArray(arr2);
        merge(arr1,arr2, arr1.length, arr2.length);
        printArray(merge(arr1,arr2, arr1.length, arr2.length));
    }

    public static int[] merge(int [] arr1,int [] arr2,int n,int m){
        int [] result=new int[m+n];
        int i=0;int j=0;int k=0;
        while (i<n && j<m){
            if (arr1[i]<arr2[j]){
                result[k]=arr1[i];
                i++;
            }else {
                result[k]=arr2[j];
                j++;
            }
            k++;
        }
        while (i<n){
            result[k]=arr1[i];
            i++;k++;
        }
        while (j<m){
            result[k]=arr2[j];
            j++;k++;
        }
        return result;
    }

    //print
    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
