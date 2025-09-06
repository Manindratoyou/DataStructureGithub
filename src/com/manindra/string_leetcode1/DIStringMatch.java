package com.manindra.string_leetcode1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DIStringMatch {

    public static void main(String[] args) {
        DIStringMatch obj = new DIStringMatch();
        System.out.println(Arrays.toString(obj.diStringMatch("IDID"))); // [0,4,1,3,2]
        System.out.println(Arrays.toString(obj.diStringMatch("III")));  // [0,1,2,3]
        System.out.println(Arrays.toString(obj.diStringMatch("DDI")));  // [3,2,0,1]
    }

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int low = 0, high = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }
        result[n] = low; // last remaining number
        return result;
    }

    public int[] diStringMatch2(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int[] low = {0}, high = {n};

        IntStream.range(0, n).forEach(i -> {
            if (s.charAt(i) == 'I') {
                res[i] = low[0]++;
            } else {
                res[i] = high[0]--;
            }
        });

        res[n] = low[0]; // last number
        return res;
    }
}

