package com.manindra.leetcodemedium_2;

public class StringCompression { //Solution 443

    public static void main(String[] args) {
        char[] chars1 = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars1)); // Output: 6 → ['a','2','b','2','c','3']

        char[] chars2 = {'a'};
        System.out.println(compress(chars2)); // Output: 1 → ['a']

        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars3)); // Output: 4 → ['a','b','1','2']
    }

    public static int compress(char[] chars) {
        int index = 0;  // position to write compressed data
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count how many times the current char repeats
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character
            chars[index++] = currentChar;

            // Write the count if more than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}

