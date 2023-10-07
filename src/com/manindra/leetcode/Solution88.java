package com.manindra.leetcode;

public class Solution88 { //merge sorted array

    public static void main(String[] args) {

        int [] arr1=new int[7];
        arr1[0]=1;
        arr1[1]=2;
        arr1[2]=3;

        int [] arr2={2,5,6};

        merge(arr1,3,arr2,3); //m and n number of elements in array1 and array2
        System.out.println("Merge Sorted Array : ");
        for (int arr : arr1)
            System.out.print(arr+" ");
    }

    static void merge(int [] arr1 ,int m, int [] arr2,int n){

        int i= m-1;//pointer for end of arr1
        int j= n-1;//pointer for end of arr2
        int k= m+n-1;//pointer for the end of merged array(arr1)

        while (i>=0 && j>=0){
            if (arr1[i]>arr2[j])  arr1[k--]=arr1[i--];
            else arr1[k--]=arr2[j--];
        }
        //if there are remaining element in arr2 ,copy them to arr1
        while (j>=0)
            arr1[k--]=arr2[j--];
    }
}
