package com.manindra.sorting;

import java.util.Arrays;

public class UnionSortedArray {

    public static void main(String[] args) {
      int [] arr1={3,5,8};
      int [] arr2={2,8,9,10,15};
       // unionTwoSortedArraySolOne(arr1,arr2, arr1.length, arr2.length);
        unionTwoSortedArraySolTwo(arr1,arr2, arr1.length, arr2.length);
    }

    static void unionTwoSortedArraySolOne(int [] arr1,int[] arr2,int m,int n){
        int [] arr3=new int[m+n];
        for (int i=0;i<m;i++)
            arr3[i]=arr1[i];
        for (int i=0;i<n;i++)
            arr3[m+i]=arr2[i];
        Arrays.sort(arr3);
        for (int i=0;i<m+n;i++){
            if (i==0 || arr3[i]!=arr3[i-1])
                System.out.print(arr3[i]+" ");
        }
    }
    static void unionTwoSortedArraySolTwo(int [] arr1,int[] arr2,int m,int n){
        int i=0,j=0;
        while (i<m && j<n){
            if (i>0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            if (j>0 && arr2[j]==arr2[j-1]){
                j++;
                continue;
            }
            if (arr1[i]<arr2[j]){
                System.out.print(arr1[i] +" ");
                i++;
            } else if (arr1[i]>arr2[j]) {
                System.out.print(arr2[j]+" ");
                j++;
            }
            else {
                System.out.print(arr1[i] +" ");
                i++;
                j++;
            }
        }//while loop ends
        while (i<m){
            if (i>0 && arr1[i]!=arr1[i-1]){
                System.out.print(arr1[i]+" ");
                i++;
            }
        }
        while (j<n){
            if (j>0 && arr2[j]!=arr2[j-1]){
                System.out.print(arr2[j] +" ");
                j++;
            }
        }

    }

}
