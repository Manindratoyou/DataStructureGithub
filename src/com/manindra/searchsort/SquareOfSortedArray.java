package com.manindra.searchsort;

import java.util.Arrays;

public class SquareOfSortedArray {

    public static void main(String[] args) {

        int [] arr={-4,-1,0,3,10};
        int [] nums={-7,-4,1,0,3,10};
        Arrays.stream(sortedSquare(arr)).sequential().forEach(System.out::println);
        System.out.println("=========");
        int [] result=sortedSquaresSolutionTwo(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortedSquare(int [] arr){
        int n= arr.length;
        int [] result=new int[n];
        int i=0,j=n-1;
        for (int k=n-1;k>=0;k--){
            if (Math.abs(arr[i])>Math.abs(arr[j])){
                result[k]=arr[i]*arr[i];
                i++;
            }else {
                result[k]=arr[j]*arr[j];
                j--;
            }
        }
        return result;
    }

    static int[] sortedSquaresSolutionTwo(int[] nums) {

        int[] result = new int[nums.length];

        // Square all elements
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int head = 0;
        int tail = nums.length - 1;

        // Set them at right place in the result array
        for (int pos = nums.length - 1; pos >= 0; pos--) {

            if (nums[head] > nums[tail]) {
                result[pos] = nums[head];
                // Increment head pointer
                head++;
            } else {
                result[pos] = nums[tail];
                // Increment tail pointer
                tail--;
            }
        }

        return result;
    }
}
