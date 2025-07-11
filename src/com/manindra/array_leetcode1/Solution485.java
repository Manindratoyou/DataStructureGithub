package com.manindra.array_leetcode1;

public class Solution485 { //Max Consecutive Ones

    public static void main(String[] args) {

        int arr[] = {0, 1, 1, 1, 0, 1, 1};
        int[] arr1 = {1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0};
        //System.out.println(maxConsecutiveOnes(arr));
        //System.out.println(findMaxConsecutiveOnes(arr));
        System.out.println(findMaxConsecutiveOnes2(arr));
        System.out.println(findMaxConsecutiveOnes2(arr1));
    }

    static int maxConsecutiveOnes(int[] arr) {

        int result = 0, current = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                current = 0;
            else {
                current++;
                result = Math.max(result, current);
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

    static int findMaxConsecutiveOnes2(int[] nums) { //sliding window

        int left = 0;
        int ans = -1; //or 0
        int window = 0; // or sum

        for (int right = 0; right < nums.length; right++) {

            //"add" elements nums[right] to window

            window += nums[right];

            //while condition not met
            // do some logic to remove left from window and left ++
            while (right - left + 1 != window) {
                window -= nums[left];
                left++;
            }

            //update the answer
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
