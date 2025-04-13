package com.manindra.heap_ds_leetcode;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class ReorganizeString { //solution 767

    public static void main(String[] args) {
        ReorganizeString obj = new ReorganizeString();

        String input1 = "aab";
        String input2 = "aaab";
        String input3 = "vvvlo";
        String input4 = "xxxrwppk";

        System.out.println("Reorganized string for '" + input1 + "' is: " + obj.reorganizeString(input1));
        System.out.println("Reorganized string for '" + input2 + "' is: " + obj.reorganizeString(input2));
        System.out.println("Reorganized string for '" + input3 + "' is: " + obj.reorganizeString(input3));
        System.out.println("Reorganized string for '" + input4 + "' is: " + obj.reorganizeString(input4));
    }

    String reorganizeString(String str) {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++)
            hash[str.charAt(i) - 'a']++;

        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++)
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }

        if (max > (str.length() + 1) / 2)
            return "";

        char[] res = new char[str.length()];

        // Fill all even places with majority character
        int idx = 0;
        while (hash[letter]-- > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
        }

        // Fill the remaining characters
        for (int i = 0; i < hash.length; i++)
            while (hash[i]-- > 0) {
                if (idx >= res.length)
                    idx = 1;

                res[idx] = (char) (i + 'a');
                idx += 2;
            }

        return String.valueOf(res);
    }

    public static String reorganizeString2(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) ->
                freq[b - 'a'] - freq[a - 'a']);

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (freq[ch - 'a'] > 0) {
                maxHeap.offer(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (maxHeap.size() >= 2) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            result.append(first).append(second);
            freq[first - 'a']--;
            freq[second - 'a']--;

            if (freq[first - 'a'] > 0) maxHeap.offer(first);
            if (freq[second - 'a'] > 0) maxHeap.offer(second);
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (freq[last - 'a'] > 1) return "";
            result.append(last);
        }

        return result.toString();
    }

    public static String reorganizeString3(String s) {
        int[] freq = new int[26];
        s.chars().forEach(c -> freq[c - 'a']++);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> freq[b - 'a'] - freq[a - 'a']
        );

        IntStream.range(0, 26)
                .filter(i -> freq[i] > 0)
                .mapToObj(i -> (char) ('a' + i))
                .forEach(maxHeap::offer);

        StringBuilder sb = new StringBuilder();

        while (maxHeap.size() >= 2) {
            char ch1 = maxHeap.poll();
            char ch2 = maxHeap.poll();

            sb.append(ch1).append(ch2);
            freq[ch1 - 'a']--;
            freq[ch2 - 'a']--;

            if (freq[ch1 - 'a'] > 0) maxHeap.offer(ch1);
            if (freq[ch2 - 'a'] > 0) maxHeap.offer(ch2);
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (freq[last - 'a'] > 1) return "";
            sb.append(last);
        }

        return sb.toString();
    }

}
