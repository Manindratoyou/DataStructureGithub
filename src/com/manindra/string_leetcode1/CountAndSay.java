package com.manindra.string_leetcode1;

public class CountAndSay { //solution 38

    public static void main(String[] args) {
        System.out.println(countAndSay(1)); // "1"
        System.out.println(countAndSay(4)); // "1211"
        System.out.println(countAndSay(5)); // "111221"
    }

    public static String countAndSay(int n) {
        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;

            for (int j = 1; j <= result.length(); j++) {
                if (j < result.length() && result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            result = next.toString();
        }
        return result;
    }


}

