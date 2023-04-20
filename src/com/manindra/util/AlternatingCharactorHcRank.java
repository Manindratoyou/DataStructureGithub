package com.manindra.util;

import java.util.Stack;

public class AlternatingCharactorHcRank {

    public static void main(String[] args) {

        System.out.println(alternatingCharacters("AABAAB"));//Remove A at positions 0 and 3  to make s=ABAB in 2 deletions.
    }

    public static int alternatingCharacters(String s) {
        Stack<Character> stack= new Stack<>();
        stack.push(s.charAt(0));
        int deletions=0;
        for(int i=1;i<s.length();i++){
            if(stack.peek()==s.charAt(i))
                deletions++;
            else
                stack.push(s.charAt(i));
        }
        System.out.println(stack);
        return deletions;

    }
}
