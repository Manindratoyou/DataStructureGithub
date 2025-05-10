package com.manindra.stack_leetcode;

import java.util.Stack;

public class BackspaceStringCompare { //solution 844

    public static void main(String[] args) {
        BackspaceStringCompare stringCompare = new BackspaceStringCompare();
        //String s = "ab#c", t = "ad#c";
        //String s = "ab##", t = "c#d#";
        String s1 = "ab#cde#f##xy", t1 = "acxy";
        System.out.println(stringCompare.backspaceCompare(s1, t1));
        System.out.println(backspaceCompareSolutionTwo(s1, t1));
    }

    public boolean backspaceCompare(String s, String t) {
        return getActual(s).equals(getActual(t));
    }

    private String getActual(String input) {
        StringBuilder actualString = new StringBuilder();
        int hashCount = 0;

        for (int i = input.length() - 1; i >= 0; i--) {

            //keep a count of backspace character
            if (input.charAt(i) == '#') {
                hashCount++;
                continue;
            }

            //if backspace count >0 reduce it and skip the character
            if (hashCount > 0) {
                hashCount--;
            } else {
                //if no backspace ,just insert at beginning
                actualString.insert(0, input.charAt(i));
            }
        }
        return actualString.toString();
    }

    static boolean backspaceCompareSolutionTwo(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!st1.isEmpty())
                    st1.pop();
            } else
                st1.push(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!st2.isEmpty())
                    st2.pop();
            } else
                st2.push(t.charAt(i));
        }
        if (st1.size() != st2.size())
            return false;
        while (!st1.isEmpty()) {
            char ch1 = st1.pop();
            char ch2 = st2.pop();
            if (ch1 != ch2)
                return false;
        }
        return true;
    }
}
