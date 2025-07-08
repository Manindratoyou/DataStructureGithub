package com.manindra.array_leetcode1;

public class Solution1662 { //Check If Two String Arrays are Equivalent

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};

        boolean result = arrayStringsAreEqualSolutionOne(word1, word2);
        //boolean result1 = arrayStringsAreEqualSolutionTwo(word1, word2);

        System.out.println("Are the arrays equivalent? " + result);
        //System.out.println("Are the arrays equivalent? " + result1);
    }

    public static boolean arrayStringsAreEqualSolutionOne(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int idx1 = 0, idx2 = 0;

        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(idx1) != word2[j].charAt(idx2)) {
                return false;
            }

            idx1++;
            if (idx1 == word1[i].length()) {
                idx1 = 0;
                i++;
            }

            idx2++;
            if (idx2 == word2[j].length()) {
                idx2 = 0;
                j++;
            }
        }

        return i == word1.length && j == word2.length;
    }


    //Auxiliary Space: O(m + n) Time Complexity: O(m + n)
    public static boolean arrayStringsAreEqualSolutionTwo(String[] word1, String[] word2) {

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (String word : word1) {
            str1.append(word);
        }

        for (String word : word2) {
            str2.append(word);
        }

        return str1.toString().equals(str2.toString());
    }

}
