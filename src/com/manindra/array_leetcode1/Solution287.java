package com.manindra.array_leetcode1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Find the Duplicate Number
//Input: nums = [1,3,4,2,2]
//Output: 2
public class Solution287 {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2}; //2
        int[] nums1 = {1, 1, 2}; //1
        int[] nums2 = {3, 1, 3, 4, 2, 3}; //3
        System.out.println(findDuplicateEfficientSolution(nums));
        System.out.println(findDuplicateSolFour(nums2));

    }

    //optimal solution in O(n) time and O(1) space
    static int findDuplicateEfficientSolution(int[] nums) {

        //start a fast and slow pointer until they meet
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        //as soon as they meet ,move both pointers at same speed until they meet again
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    //time O(n log n)	space O(1)
    static int findDuplicateSolTwo(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    //Time: O(n), Space: O(n)
    static int findDuplicateSolThree(int[] nums) {

        Set<Integer> numset = new HashSet<>();
        for (int num : nums) {
            if (numset.contains(num))
                return num;
            numset.add(num);
        }
        return -1;
    }

    // Time: O(n²), Space: O(1)
    static int findDuplicateSolFour(int[] nums) { //brut force

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }

    static int findDuplicateUsingStream(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(nums)
                .filter(n -> !seen.add(n)) // if add returns false, it's a duplicate
                .findFirst()
                .orElse(-1); // should never happen in valid input
    }

    static int findDuplicateBinarySearch(int[] nums) { //check this
        Arrays.sort(nums);
        int low = 1;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                high = mid; // duplicate is in lower half
            } else {
                low = mid + 1; // duplicate is in upper half
            }
        }

        return low;
    }

}
