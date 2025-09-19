package com.manindra.string_leetcode1;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments { //solution 722

    public static List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();

        for (String line : source) {
            int i = 0;
            if (!inBlock) sb.setLength(0); // reset if not in block comment

            while (i < line.length()) {
                if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    inBlock = true;
                    i += 2;
                } else if (inBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inBlock = false;
                    i += 2;
                } else if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break; // ignore rest of the line
                } else if (!inBlock) {
                    sb.append(line.charAt(i++));
                } else {
                    i++;
                }
            }

            if (!inBlock && sb.length() > 0) {
                result.add(sb.toString());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] source = {
                "/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;",
                "}"
        };

        List<String> output = removeComments(source);
        output.forEach(System.out::println);
    }
}

