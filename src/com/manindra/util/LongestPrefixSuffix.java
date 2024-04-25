package com.manindra.util;

public class LongestPrefixSuffix {

    public static void main(String[] args) {

        String input="ababcdabab";

        int n=input.length();
        String longest="";

        for (int i=1;i<n;i++){
            String prefix=input.substring(0,i);
            String suffix=input.substring(n-i);

            if (prefix.equals(suffix))
                longest=prefix;
        }
        System.out.println(longest);
    }
}
