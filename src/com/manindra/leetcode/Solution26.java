package com.manindra.leetcode;

import java.util.Arrays;

public class Solution26 {

    public static void main(String[] args) {

        int [] arr={1,1,2};
        int [] arr1={0,0,1,1,1,2,2,3,3,4};
        int n=removeDuplicates(arr1);
        for (int i=0;i<n;i++){
            System.out.print(arr1[i] + " ");
        }

    }
     static int removeDuplicates(int [] arr){
        int result=1;
        for (int i=1;i<arr.length;i++){
            if (arr[i] !=arr[i-1]){
                arr[result]=arr[i];
                result++;
            }
        }
        return result;
     }
}
