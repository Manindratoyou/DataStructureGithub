package com.manindra.array_leetcode1;

public class Solution485 { //Max Consecutive Ones

    public static void main(String[] args) {

        int arr[] = {0, 1, 1, 1, 0, 1, 1};
        System.out.println(maxConsecutiveOnes(arr));
        System.out.println(findMaxConsecutiveOnes(arr));
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
    static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        // Iterate through all the elements
        // and keep a track of the maximum 1s
        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max;
    }
}
