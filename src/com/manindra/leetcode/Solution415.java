package com.manindra.leetcode;

public class Solution415 { //Add String

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        String num3 = "456";
        String num4 = "77";
       //String result = addStrings(num1, num2);
       String result = addStrings(num3, num4);
        System.out.println("Sum of the two strings: " + result);
    }

    static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {
            int x = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            result.append(sum % 10);

            i--;
            j--;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

}
