package com.manindra.leetcodemedium_2;

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

}
