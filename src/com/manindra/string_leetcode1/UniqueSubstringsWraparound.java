package com.manindra.string_leetcode1;

public class UniqueSubstringsWraparound { //solution 467

    public static void main(String[] args) {
        UniqueSubstringsWraparound obj = new UniqueSubstringsWraparound();
        System.out.println(obj.findSubstringInWraproundString("a"));       // 1
        System.out.println(obj.findSubstringInWraproundString("cac"));     // 2
        System.out.println(obj.findSubstringInWraproundString("zab"));     // 6
    }

    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26]; // dp[i] -> longest substring ending with 'a' + i
        int k = 0; // length of current valid substring

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 ||
                    (s.charAt(i - 1) == 'z' && s.charAt(i) == 'a'))) {
                k++;
            } else {
                k = 1;
            }

            int index = s.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], k);
        }

        int result = 0;
        for (int val : dp) result += val;
        return result;
    }
}

