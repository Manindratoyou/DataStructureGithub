package com.manindra.util;

public class Anagram {

    public static void main(String[] args) {

        String s1="silent",s2="listen";
        System.out.println(isAnagram(s1,s2));
    }

    static boolean isAnagram(String s1,String s2){
        //convert both string to lower case to ignore case match
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();

        //stripe of all the white spaces
        s1=s1.replace(" ","");
        s2=s2.replace(" ","");

        //initialize the bucket array
        int [] count=new int[26];

        //fill the bucket
        for (int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
        }

        //empty the bucket
        for (int i=0;i<s2.length();i++){
            count[s2.charAt(i)-'a']--;
        }

        //check if all bucket are empty
        for (int c: count){
            if (c!=0)
                return false;
        }
        return true;
    }
}
