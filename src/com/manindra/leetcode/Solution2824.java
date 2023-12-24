package com.manindra.leetcode;

import java.util.Arrays;

/*
Input: nums = [-1,1,2,3,1], target = 2
Output: 3
Explanation: There are 3 pairs of indices that satisfy the conditions in the statement:
- (0, 1) since 0 < 1 and nums[0] + nums[1] = 0 < target
- (0, 2) since 0 < 2 and nums[0] + nums[2] = 1 < target
- (0, 4) since 0 < 4 and nums[0] + nums[4] = 0 < target
Note that (0, 3) is not counted since nums[0] + nums[3] is not strictly less than the target.
 */
public class Solution2824 { //Count Pairs Whose Sum is Less than Target

    public static void main(String[] args) {

        int [] nums = {-1,1,2,3,1};int target = 2;
        test(nums,target);
        System.out.println("===");
        System.out.println(countPairs(nums,target));
    }

    static void test(int [] arr,int target){

        int count=0;
        for (int i=0;i< arr.length;i++){
            for (int j=i+1;j< arr.length;j++){
                if (arr[i]+arr[j]<target){
                    System.out.println(i+" "+j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static int countPairs(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int count = 0;
        int n = nums.length;

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left <= right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < target) {
                    // If the sum is less than the target, all pairs with the current left and right elements are valid.
                    count += right - left + 1;
                    left++;
                } else {
                    // If the sum is greater or equal to the target, move the right pointer to the left.
                    right--;
                }
            }
        }

        return count;
    }
}
