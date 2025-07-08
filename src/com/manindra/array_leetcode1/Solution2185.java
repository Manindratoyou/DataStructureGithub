package com.manindra.array_leetcode1;

import java.util.Arrays;

/*
Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
 */
public class Solution2185 { //Counting Words With a Given Prefix

    public static void main(String[] args) {

        String [] words = {"pay","attention","practice","attend"};
        String pref = "at";

        int count= (int) Arrays.stream(words).sequential().
                filter(s -> s.startsWith(pref)).filter(i->i.contains(pref)).count();
        System.out.println(count);

        System.out.println(prefixCount(words,pref));
    }

    static int prefixCount(String [] words,String pref){
        int ans=0;
        for (String s: words){
            if (s.startsWith(pref))
                ans++;
        }
        return ans;
    }
}
