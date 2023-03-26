package com.manindra.util;

import java.util.Arrays;

public class TwoSumProblem {

    public static void main(String[] args) {
        int [] arr={2,11,5,10,7,8};
        int result [] =twoSum(arr,9);
        printArray(result);

    }
    public static int[] twoSum(int arr[],int target){
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        int [] result =new int[2];
        while (left<right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result[0] = arr[left];
                result[1] = arr[right];
                return result;
            } else if (sum < target) {
                left++;
            } else
                right--;
        }
            return new int[0];
    }

    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
