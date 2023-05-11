package com.manindra.string;

public class PrintFrequenciesOfChar {

    public static void main(String[] args) {
        /*char x='a';
        System.out.println((int)x);*/

        String str="manindra";
        int [] count=new int[26];
        for (int i=0;i<str.length();i++){
            count[str.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++){
            if (count[i]>0)
                System.out.println((char)(i+'a')+" "+count[i]);
        }
    }
}
