package com.manindra.string_leetcode1;

public class DetectCapital { //solution 520

    public static void main(String[] args) {
        DetectCapital obj = new DetectCapital();
        System.out.println(obj.detectCapitalUse("USA"));     // true
        System.out.println(obj.detectCapitalUse("leetcode"));// true
        System.out.println(obj.detectCapitalUse("Google"));  // true
        System.out.println(obj.detectCapitalUse("FlaG"));    // false
    }

    public boolean detectCapitalUse(String word) {
        // All uppercase
        if (word.equals(word.toUpperCase()))
            return true;

        // All lowercase
        if (word.equals(word.toLowerCase()))
            return true;

        // First letter uppercase + rest lowercase
        if (Character.isUpperCase(word.charAt(0))
                && word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }

        return false;
    }

}

