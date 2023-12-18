package com.manindra.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    static final int CHAR=256;

    public static void main(String[] args) {
        System.out.println(areAnagramSolOne("listen","silent"));
        System.out.println(areAnagramSolTwo("listen","silent"));
        System.out.println(areAnagramSolThree("listen","silent"));
    }

    static boolean areAnagramSolOne(String s1,String s2){
        if (s1.length()!=s2.length())
            return false;
        char[] a1=s1.toCharArray();
        Arrays.sort(a1);
        s1=new String(a1);

        char[] a2=s2.toCharArray();
        Arrays.sort(a2);
        s2=new String(a2);
        return s1.equals(s2);
    }
    static boolean areAnagramSolTwo(String s1,String s2){
        if (s1.length()!=s2.length())
            return false;
        int [] count=new int[CHAR];
        for (int i=0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i=0;i<CHAR;i++){
            if (count[i]!=0)
                return false;
        }
        return true;
    }

    static boolean areAnagramSolThree(String s1,String s2){
        if (s1.length()!=s2.length())
            return false;

        Map<Character,Integer> countMap=new HashMap<>();

        for (char c:s1.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }

        for (char c:s2.toCharArray()){
           if (!countMap.containsKey(c) || countMap.get(c)==0)
               return false;

           countMap.put(c, countMap.get(c)-1);
        }

        return true;

    }
}
