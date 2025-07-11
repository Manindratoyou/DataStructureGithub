package com.manindra.sliding_window_leetcode;

public class MaxConsecutiveOnesIII { //solution 1004

    public static void main(String[] args) {
        // Test case
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
        int k = 2;

        // Create an instance of the class and call the method
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();
        int result = solution.longestOnes(nums, k);

        // Print the result
        System.out.println("Maximum consecutive ones with at most " + k + " zeroes: " + result);

        System.out.println(findMaxConsecutiveOnes2(nums,k));
    }

    static int longestOnes(int[] nums, int k) {

        int zeroCount = 0;
        int start = 0;
        int max_ones = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0)
                zeroCount++;

            while (zeroCount > k) {
                if (nums[start] == 0)
                    zeroCount--;

                start++;
            }

            max_ones = Math.max(max_ones, end - start + 1);
        }
        return max_ones;
    }

    static int findMaxConsecutiveOnes2(int[] nums, int k) { //sliding window

        int left = 0;
        int ans = 0; // or -1
        int window = 0; // or sum

        for (int right = 0; right < nums.length; right++) {

            //"add" elements nums[right] to window

            window += nums[right];

            //while condition not met
            // do some logic to remove left from window and left ++
            while (window + k < right - left + 1) {
                window -= nums[left];
                left++;
            }

            //update the answer
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
