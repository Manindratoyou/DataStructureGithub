package com.manindra.array_leetcode1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstPalindrome { //solution 2108

    public static void main(String[] args) {

        String [] test1={"abc","def","aba","ghi"};
        System.out.println(firstPalindrome(test1));

        String [] test2={"xyz","madam","12321","efg"};
        System.out.println(firstPalindrome(test2));
    }

    static String firstPalindrome(String [] words){

        Set<String> set=new HashSet<>(Arrays.asList(words));

        for (String word: words){
            String reversed=new StringBuffer(word).reverse().toString();
            if (word.equals(reversed) && set.contains(word))
                return word;
        }
        return "";
    }

    static boolean palindrome(String word){
        for (int i=0;i<word.length()/2;i++){
            if (word.charAt(i)!=word.charAt(word.length()-1-i))
                return false;
        }
        return true;
    }
}
