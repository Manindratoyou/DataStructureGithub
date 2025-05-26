package com.manindra.leetcodeEasy;

public class RearrangeCharacters { //solution 2287

    public static void main(String[] args) {

        String s = "ilovecodingonleetcode", target = "code";
        String s1= "abcba", target1 = "abc";
        String s2 = "abbaccaddaeea", target2 = "aaaaa";
        System.out.println(rearrangeCharacters(s,target));
        System.out.println(rearrangeCharacters(s1,target1));
        System.out.println(rearrangeCharacters(s2,target2));

    }

    static int rearrangeCharacters(String s, String target) {
        int[] sCount = new int[26];
        int[] targetCount = new int[26];

        for (char c : s.toCharArray()) {
            sCount[c - 'a']++;
        }

        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }

        int minCopies = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (targetCount[i] > 0) {
                minCopies = Math.min(minCopies, sCount[i] / targetCount[i]);
            }
        }

        return minCopies;
    }


}

