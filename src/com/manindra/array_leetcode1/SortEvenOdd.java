package com.manindra.array_leetcode1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenOdd { //solution 2164

    public static void main(String[] args) {
        SortEvenOdd obj = new SortEvenOdd();
        int[] nums = {4, 1, 2, 3};
        System.out.println(Arrays.toString(obj.sortEvenOdd(nums))); // [2, 3, 4, 1]
    }

    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }

        Collections.sort(even); // ascending
        Collections.sort(odd, Collections.reverseOrder()); // descending

        int e = 0, o = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i % 2 == 0) ? even.get(e++) : odd.get(o++);
        }

        return nums;
    }

    public int[] sortEvenOdd2(int[] nums) {
        List<Integer> even = IntStream.range(0, nums.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> nums[i])
                .sorted()
                .collect(Collectors.toList());

        List<Integer> odd = IntStream.range(0, nums.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> nums[i])
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int[] result = new int[nums.length];
        int e = 0, o = 0;
        for (int i = 0; i < nums.length; i++) {
            result[i] = (i % 2 == 0) ? even.get(e++) : odd.get(o++);
        }
        return result;
    }
}

