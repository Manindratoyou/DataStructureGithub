package com.manindra.util;

public class HighestOddNumber {
    public static void main(String[] args) {
        //System.out.println(getHighestOddPrefix("5688248"));     // Output: "5"
        System.out.println(getHighestOddPrefix("61632826"));    // Output: "6163"
        System.out.println(getHighestOddPrefix("616338261"));   // Output: "616338261"
    }

    public static String getHighestOddPrefix(String num) {
        for (int i = num.length(); i > 0; i--) {
            String prefix = num.substring(0, i);
            // Check if the last digit of the prefix is odd
            //if ((prefix.charAt(prefix.length() - 1) - '0') % 2 != 0) {
            if ((prefix.charAt(prefix.length() - 1)) % 2 != 0) {
                return prefix;
            }
        }
        // Return an empty string if no odd number is found
        return "";
    }
}
