package com.manindra.string_leetcode1;

import java.util.*;

public class ReverseParentheses { //solution 1190

    public static void main(String[] args) {
        System.out.println(reverseParentheses("a(bc)de"));          // Output: acbde
        System.out.println(reverseParentheses("a(bc(def)g)h"));     // Output: agfedcbh
        System.out.println(reverseParentheses("(u(love)i)"));       // Output: iloveu
        System.out.println(reverseParentheses("(ed(et(oc))el)"));   // Output: leetcode
    }

    public static String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder()); // base level

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(new StringBuilder()); // new level
            } else if (ch == ')') {
                StringBuilder inner = stack.pop(); // pop current
                inner.reverse(); // reverse
                stack.peek().append(inner); // append to previous
            } else {
                stack.peek().append(ch); // add char to current
            }
        }

        return stack.peek().toString();
    }
}

