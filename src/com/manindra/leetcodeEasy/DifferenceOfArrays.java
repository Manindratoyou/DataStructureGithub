package com.manindra.leetcodeEasy;

import java.util.*;

public class DifferenceOfArrays { //solution 2215

    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[]{3,4,5}));
        System.out.println(findDifference(new int[]{7,8,9}, new int[]{1,2,3}));
        System.out.println(findDifference(new int[]{1,2}, new int[]{1,2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1)
            set1.add(n);
        for (int n : nums2)
            set2.add(n);

        List<Integer> onlyIn1 = new ArrayList<>();
        List<Integer> onlyIn2 = new ArrayList<>();

        for (int n : set1) {
            if (!set2.contains(n))
                onlyIn1.add(n);
        }

        for (int n : set2) {
            if (!set1.contains(n))
                onlyIn2.add(n);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(onlyIn1);
        result.add(onlyIn2);
        return result;
    }
}

