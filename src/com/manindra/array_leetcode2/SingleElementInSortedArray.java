package com.manindra.array_leetcode2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleElementInSortedArray { //solution 540

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 8, 8};
        System.out.println("Single Element: " + singleNonDuplicate(nums)); // Output: 4
    }

    public static int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even
            if (mid % 2 == 1)
                mid--;

            // Check the pair
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }

    public static int singleNonDuplicateBrute(int[] nums) {
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) return nums[i];
        }
        return nums[nums.length - 1];
    }

    public static int singleNonDuplicateXor(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }

    public static int singleNonDuplicateStream(int[] nums) {

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Integer i = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(-1);
        return i;
    }
}

