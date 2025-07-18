package com.manindra.array_leetcode1;

public class SearchRotatedSortedArrayII { //Solution 81

    public static void main(String[] args) {
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 0));  // true
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 3));  // false
        System.out.println(search(new int[]{1,0,1,1,1}, 0));      // true
        System.out.println(search(new int[]{1,1,3,1}, 3));        // true
    }

    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;

            // Handle duplicates: skip over duplicates on left
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return false;
    }
}

