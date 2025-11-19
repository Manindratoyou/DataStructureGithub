package com.manindra.string_leetcode1;

public class RemoveKDigits { //solution 402

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // 1219
        System.out.println(removeKdigits("10200", 1));   // 200
        System.out.println(removeKdigits("10", 2));      // 0
    }

    public static String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        StringBuilder stack = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }

        // if still k left → remove from end
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // remove leading zeros
        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0') {
            i++;
        }

        String result = stack.substring(i);

        return result.length() == 0 ? "0" : result;
    }

}

