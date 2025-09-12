package com.manindra.string_leetcode1;

import java.util.*;

public class NumberOfDifferentIntegers { //solution 1805

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34")); // 3
        System.out.println(numDifferentIntegers("leet1234code234")); // 2
        System.out.println(numDifferentIntegers("a1b01c001")); // 1
    }

    public static int numDifferentIntegers(String word) {
        Set<String> uniqueNumbers = new HashSet<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else {
                if (currentNumber.length() > 0) {
                    uniqueNumbers.add(removeLeadingZeros(currentNumber.toString()));
                    currentNumber.setLength(0);
                }
            }
        }

        // Process last number if exists
        if (currentNumber.length() > 0) {
            uniqueNumbers.add(removeLeadingZeros(currentNumber.toString()));
        }

        return uniqueNumbers.size();
    }

    private static String removeLeadingZeros(String num) {
        int i = 0;
        while (i < num.length() && num.charAt(i) == '0') {
            i++;
        }
        return i == num.length() ? "0" : num.substring(i);
    }

}

