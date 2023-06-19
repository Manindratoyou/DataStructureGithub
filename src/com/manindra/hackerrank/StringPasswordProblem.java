package com.manindra.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class StringPasswordProblem {

    public static void main(String[] args) {
        String password="Ab1";//3 Ab1
        String password1="#HackerRank";//11 #HackerRank
        System.out.println(stringPasswordProblem(11,password1));
    }
    static int stringPasswordProblem(int n, String password){
        boolean lowercase=false;
        boolean uppercase=false;
        boolean number=false;
        boolean special=false;
        char[] schars="!@#$%^&*()_+".toCharArray();

        Set<Character> characterSet = new HashSet<>();
        for (char c: schars)
            characterSet.add(c);
        for (int i=0;i<n;i++){
            char c=password.charAt(i);
            if (c>='0' && c<='9')         number=true;
            if (c>='a' && c<='z')         lowercase=true;
            if (c>='A' && c<='Z')         uppercase=true;
            if (characterSet.contains(c)) special=true;
        }
        int need=0;
        need+=lowercase ? 0 :1;
        need+=uppercase ? 0 :1;
        need+=number ? 0 :1;
        need+=special ? 0 :1;
        return n+need < 6 ? 6-n :need;
    }
}
