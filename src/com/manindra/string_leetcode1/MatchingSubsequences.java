package com.manindra.string_leetcode1;

import java.util.*;

public class MatchingSubsequences { //solution 792

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words)); // 3
    }

    public static int numMatchingSubseq(String s, String[] words) {
        List<Queue<String>> buckets = new ArrayList<>(26);

        // init buckets
        for (int i = 0; i < 26; i++) {
            buckets.add(new LinkedList<>());
        }

        // put each word in its starting bucket
        for (String w : words) {
            buckets.get(w.charAt(0) - 'a').offer(w);
        }

        int count = 0;

        for (char c : s.toCharArray()) {
            Queue<String> q = buckets.get(c - 'a');
            int size = q.size();  // important: process only current words

            while (size-- > 0) {
                String word = q.poll();

                if (word.length() == 1) {
                    count++;        // completed subsequence
                } else {
                    String next = word.substring(1);
                    buckets.get(next.charAt(0) - 'a').offer(next);
                }
            }
        }

        return count;
    }

}

