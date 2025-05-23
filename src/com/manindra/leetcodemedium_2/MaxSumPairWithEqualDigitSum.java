package com.manindra.leetcodemedium_2;

import java.util.*;
import java.util.stream.*;

public class MaxSumPairWithEqualDigitSum { //solution 2342

    public static void main(String[] args) {
        MaxSumPairWithEqualDigitSum obj = new MaxSumPairWithEqualDigitSum();

        int[] test1 = {18, 43, 36, 13, 7};
        int[] test2 = {10, 12, 19, 14};
        int[] test3 = {51, 71, 17, 42};

        System.out.println("Standard Approach:");
        System.out.println("Test 1: " + obj.maximumSum(test1)); // 61
        System.out.println("Test 2: " + obj.maximumSum(test2)); // -1
        System.out.println("Test 3: " + obj.maximumSum(test3)); // 93

        System.out.println("\nJava 8 Streams Approach:");
        System.out.println("Test 1: " + obj.maximumSumWithStreams(test1)); // 61
        System.out.println("Test 2: " + obj.maximumSumWithStreams(test2)); // -1
        System.out.println("Test 3: " + obj.maximumSumWithStreams(test3)); // 93
    }

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;

        for (int num : nums) {
            int digitSum = sum(num);
            if (map.containsKey(digitSum)) {
                res = Math.max(res, num + map.get(digitSum));
                map.put(digitSum, Math.max(map.get(digitSum), num));
            } else {
                map.put(digitSum, num);
            }
        }

        return res;
    }

    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int maximumSumWithStreams(int[] nums) {
        return IntStream.of(nums)
                .boxed()
                .collect(Collectors.groupingBy(this::sum,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.reverseOrder())
                                        .limit(2)
                                        .collect(Collectors.toList())
                        )))
                .values().stream()
                .filter(list -> list.size() == 2)
                .mapToInt(list -> list.get(0) + list.get(1))
                .max()
                .orElse(-1);
    }
}

