package com.manindra.leetcode;

public class Solution709 { //To Lower Case

    public static void main(String[] args) {
        String input = "Hello, World!";
        System.out.println("Lowercase string: " + toLowerCase(input));
    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(n), where n is the length of the input string
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static String toLowerCaseSolutionTwo(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                chars[i] = (char) (chars[i] + 32);
            }
        }

        return new String(chars);
    }

    public static String toLowerCaseSolutionThree(String str) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            result.append(Character.toLowerCase(c));
        }

        return result.toString();
    }

}
