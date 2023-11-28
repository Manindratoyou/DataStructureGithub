package com.manindra.leetcode;

public class Solution485 { //Max Consecutive Ones

    public static void main(String[] args) {

        int arr[] = {0, 1, 1, 1, 0, 1, 1};
        System.out.println(maxConsecutiveOnes(arr));
    }

    static int maxConsecutiveOnes(int [] arr){

        int result=0,current=0;
        int n=arr.length;
        for (int i=0;i<n;i++){
            if (arr[i]==0)
                current=0;
            else {
                current++;
                result=Math.max(result,current);
            }
        }
        return result;
    }
}
