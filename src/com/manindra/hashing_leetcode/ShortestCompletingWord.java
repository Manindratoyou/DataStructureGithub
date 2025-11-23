package com.manindra.hashing_leetcode;

public class ShortestCompletingWord { //solution 748

    public static void main(String[] args) {
        String license = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord(license, words)); // step
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String result = null;

        for (String word : words) {
            if (result == null || word.length() < result.length()) {
                int[] cur = count(word);
                if (isCompleting(cur, target)) {
                    result = word;
                }
            }
        }

        return result;
    }

    private static int[] count(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[Character.toLowerCase(c) - 'a']++;
            }
        }
        return freq;
    }

    private static boolean isCompleting(int[] wordFreq, int[] targetFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < targetFreq[i]) return false;
        }
        return true;
    }

}

