package com.manindra.hackerrank;

public class CamelCase {

    public static void main(String[] args) {

        String s="saveChangesInTheEditor";
        System.out.println(camelcase(s));
        System.out.println(camelcase2(s));
        System.out.println(countWords(s));
    }

    public static int camelcase(String s) {
        int count=0;
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (ch>=65 && ch<=90)
                count++;
        }
        return count+1;
    }
    public static int camelcase2(String s) {
        long count=s.chars().filter(ch->ch>=65 && ch<=90).count();
        return (int) (count+1);
    }

    public static int countWords(String s) {
        int count = 1; // Start with 1 because the first word starts with a lowercase letter

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++; // Increment the count when encountering an uppercase letter
            }
        }

        return count;
    }
}
