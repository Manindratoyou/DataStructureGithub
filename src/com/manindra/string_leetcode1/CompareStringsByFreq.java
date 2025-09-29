package com.manindra.string_leetcode1;

import java.util.*;

public class CompareStringsByFreq { //solution 1170

    // Helper function to compute f(s)
    private int getFrequency(String s) {
        char minChar = 'z';
        int freq = 0;
        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
                freq = 1;
            } else if (c == minChar) {
                freq++;
            }
        }
        return freq;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsFreq = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsFreq[i] = getFrequency(words[i]);
        }
        Arrays.sort(wordsFreq); // binary search target

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int qFreq = getFrequency(queries[i]);
            // Find first index where wordsFreq[j] > qFreq
            int idx = upperBound(wordsFreq, qFreq);
            result[i] = wordsFreq.length - idx;
        }
        return result;
    }

    // Binary search to find first element greater than target
    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        CompareStringsByFreq obj = new CompareStringsByFreq();
        System.out.println(Arrays.toString(
                obj.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})
        )); // [1]

        System.out.println(Arrays.toString(
                obj.numSmallerByFrequency(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"})
        )); // [1,2]
    }
}

