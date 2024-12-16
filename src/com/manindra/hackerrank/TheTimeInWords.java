package com.manindra.hackerrank;

public class TheTimeInWords {

    public static void main(String[] args) {
        // Test cases
        System.out.println(timeInWords(5, 0));  // "five o' clock"
        System.out.println(timeInWords(5, 1));  // "one minute past five"
        System.out.println(timeInWords(5, 10)); // "ten minutes past five"
        System.out.println(timeInWords(5, 15)); // "quarter past five"
        System.out.println(timeInWords(5, 30)); // "half past five"
        System.out.println(timeInWords(5, 40)); // "twenty minutes to six"
        System.out.println(timeInWords(5, 45)); // "quarter to six"
        System.out.println(timeInWords(5, 47)); // "thirteen minutes to six"
        System.out.println(timeInWords(12, 57)); // "three minutes to one"
    }

    public static String timeInWords(int h, int m) {
        // Words for numbers
        String[] words = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen",
                "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two",
                "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine", "half"
        };

        if (m == 0) {
            return words[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + words[h];
        } else if (m == 30) {
            return "half past " + words[h];
        } else if (m == 45) {
            return "quarter to " + words[h + 1];
        } else if (m < 30) {
            return words[m] + " minute" + (m == 1 ? "" : "s") + " past " + words[h];
        } else {
            int minutesToNextHour = 60 - m;
            return words[minutesToNextHour] + " minute" + (minutesToNextHour == 1 ? "" : "s") + " to " + words[h + 1];
        }
    }

}
