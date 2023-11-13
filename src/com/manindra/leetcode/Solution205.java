package com.manindra.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution205 { //Isomorphic String

    public static void main(String[] args) {
        String s1="egg";
        String t1="add";

        String s2="foo";
        String t2="bar";

        System.out.println(isIsomorphic(s1,t1));
        System.out.println(isIsomorphicSolutionTwo(s2,t2));

    }

    static boolean isIsomorphic(String s,String t){
        Map<Character,Character> sMap=new HashMap<>();
        Map<Character,Character> tMap=new HashMap<>();

        for (int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);

            if (sMap.containsKey(sChar)){
                if (sMap.get(sChar)!=tChar)
                    return false;
            }else {
                tMap.put(tChar,sChar);
            }

            if (tMap.containsKey(tChar)){
                if (tMap.get(tChar)!=sChar)
                    return false;
            }else {
                tMap.put(tChar,sChar);
            }
        }
        return true;
    }
    static boolean isIsomorphicSolutionTwo(String s,String t){
        if (s.length() !=t.length()) return false;

        int [] sCharMap=new int[256];//mapping array for characters in string 's'
        int [] tCharMap=new int[256];//mapping array for characters in string 't'

        for (int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);

            //check the character mappings are different in 's' and 't'
            if (sCharMap[sChar] !=tCharMap[tChar]) return false;

            //update the character mapping in 's' and 't'
            if (sCharMap[sChar]==0)
                sCharMap[sChar] =i+1;//increment by 1 to avoid index 0 conflict.
            if (tCharMap[tChar]==0)
                tCharMap[tChar]=i+1;//increment by 1 to avoid index 0 conflict

        }

        return true;
    }

}
