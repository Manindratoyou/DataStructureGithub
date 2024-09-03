package com.manindra.sorting;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int [] arr1={10,15,20};
        int [] arr2={5,6,6,15,30,36};
        //mergeSolutionOne(arr1,arr2, arr1.length, arr2.length);
        mergeSolutionTwo(arr1,arr2, arr1.length, arr2.length);

    }

    static void mergeSolutionOne(int [] arr1,int [] arr2,int m,int n){
        int [] arr3=new int[m+n];
        for (int i=0;i<m;i++)
            arr3[i]=arr1[i];
        for (int i=0;i<n;i++)
            arr3[m+i]=arr2[i];

        Arrays.sort(arr3);

        for (int i=0;i<m+n;i++)
            System.out.print(arr3[i] + " ");
    }

    static void mergeSolutionTwo(int [] arr1,int [] arr2,int m,int n){
        int i=0,j=0;
        while (i<m && j<n){
            if (arr1[i]<=arr2[j]){
                System.out.print(arr1[i]+ " ");
                i++;
            }
            else{
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
        while (i<m){
            System.out.print(arr1[i] + " ");
            i++;
        }
        while (j<n){
            System.out.print(arr2[j] +" ");
            j++;
        }
    }

}
