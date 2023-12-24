package com.manindra.leetcode;

/*
Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 */
public class Solution1528 { //Shuffle String

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String result = restoreString(s, indices);
        System.out.println(result);
    }

    static String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {

            result[indices[i]] = s.charAt(i);
        }

        return new String(result);
    }
}
