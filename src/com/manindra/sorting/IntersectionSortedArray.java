package com.manindra.sorting;

public class IntersectionSortedArray {

    public static void main(String[] args) {

        int [] arr1={1,20,20,40,60};
        int [] arr2={2,20,20,30};
        intersectionTwoSortedArraySolOne(arr1,arr2, arr1.length, arr2.length);

    }
    //works with sorted and unsorted both
    static void intersectionTwoSortedArraySolOne(int[] arr1,int[] arr2,int m,int n ){ //tc O(m+n)
        for (int i=0;i<m;i++){
            if (i>0 && arr1[i]==arr1[i-1])
                continue;
            for (int j=0;j<n;j++){
                if (arr1[i]==arr2[j]){
                    System.out.println(arr1[i]);
                    break;
                }
            }
        }
    }
}
