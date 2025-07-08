package com.manindra.array_leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution128 { //Longest Consecutive Sequence

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums1 = {0, 1, 9, 6, 5, -1};
        int[] nums2 = {9, 1, 4, 7, 3, -1, 0, 5, 100, 101, 8, -1, 6};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutiveSolTwo(nums1));
        System.out.println(longestConsecutiveSolThree(nums2));

    }

    static int longestConsecutive(int[] nums) {

        int longestLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, Boolean.FALSE);
        }

        for (int num : nums) {
            int currentLength = 1;

            // Check in forward direction
            int nextNum = num + 1;
            while (map.containsKey(nextNum) && map.get(nextNum) == false) {

                currentLength++;
                map.put(nextNum, Boolean.TRUE);

                // Move to the next number
                nextNum++;
            }

            // Check in reverse direction
            int prevNum = num - 1;
            while (map.containsKey(prevNum) && map.get(prevNum) == false) {

                currentLength++;
                map.put(prevNum, Boolean.TRUE);

                // Move to the previous number
                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;
    }

    //solution two : Time Complexity: O(n)
    //Auxiliary Space: O(n)
    public static int longestConsecutiveSolTwo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    //solution 3 Time Complexity: O(n log n) (due to sorting)
    //Auxiliary Space: O(1)
    public static int longestConsecutiveSolThree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }

    public static int longestConsecutive4(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Step 1: Sort the array
        Arrays.sort(nums);

        int maxLength = 1;
        int currentLength = 1;

        // Step 2: Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // Skip duplicates
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                // Consecutive number found
                currentLength++;
            } else {
                // Sequence ends
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        // Final check for the last sequence
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }
}
