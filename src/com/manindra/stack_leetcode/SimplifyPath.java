package com.manindra.stack_leetcode;

import java.util.*;

public class SimplifyPath { //solution 71

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));                 // "/home"
        System.out.println(simplifyPath("/../"));                   // "/"
        System.out.println(simplifyPath("/home//foo/"));            // "/home/foo"
        System.out.println(simplifyPath("/a/./b/../../c/"));        // "/c"
        System.out.println(simplifyPath("/a/../../b/../c//.//"));   // "/c"
        System.out.println(simplifyPath("/a//b////c/d//././/.."));  // "/a/b/c"
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); // Go up
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part); // Valid dir
            }
        }

        // Build the result path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }


}

