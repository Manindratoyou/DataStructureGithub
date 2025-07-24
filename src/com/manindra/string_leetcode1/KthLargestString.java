package com.manindra.string_leetcode1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestString { //solution 1985

    public static void main(String[] args) {
        String[] nums1 = {"3", "6", "7", "10"};
        String[] nums2 = {"2", "21", "12", "1"};
        System.out.println(kthLargestNumber(nums1, 4)); // "3"
        System.out.println(kthLargestNumber(nums2, 3)); // "2"
    }

    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return b.length() - a.length(); // longer = larger
                } else {
                    return b.compareTo(a); // reverse lexicographic for descending
                }
            }
        });

        return nums[k - 1]; // kth largest after descending sort

        /*
        Arrays.sort(nums, (a, b) -> {
       if (a.length() != b.length()) return b.length() - a.length();
       return b.compareTo(a); // Descending
        });
       return nums[k - 1];
         */
    }

    public static String kthLargestNumber2(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return a.length() - b.length();

                return a.compareTo(b); // Ascending order
            }
        });

        for (String num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        return minHeap.peek(); // k-th largest
    }

    public static String kthLargestNumber3(String[] nums, int k) {
        return Arrays.stream(nums)
                .sorted((a, b) -> {
                    if (a.length() != b.length())
                        return b.length() - a.length();

                    return b.compareTo(a);
                })
                .skip(k - 1)
                .findFirst()
                .get();
    }

}

