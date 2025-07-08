package com.manindra.array_leetcode1;

import java.util.stream.IntStream;

public class FindPeakElement { //solution 162

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Peak Element Index: " + findPeakElement(nums)); // Output: 2
    }

    public static int findPeakElement(int[] nums) { //Binary Search (O(log n))
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1; // Peak lies on the right
            } else {
                high = mid;    // Peak lies on the left (including mid)
            }
        }

        return low; // or high, both point to a peak
    }

    public static int findPeakElementLinear(int[] nums) { //Linear Scan (O(n))
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public static int findPeakElementStream(int[] nums) { //Java 8 Stream-based Linear Peak Finder (O(n))
        return IntStream.range(0, nums.length)
                .filter(i ->
                        (i == 0 || nums[i] > nums[i - 1]) &&
                                (i == nums.length - 1 || nums[i] > nums[i + 1])
                )
                .findFirst()
                .orElse(-1); // if no peak (theoretically impossible in valid input)
    }
}

