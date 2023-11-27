package com.manindra.leetcode;

public class Solution434 { //number of segment in a string

    public static void main(String[] args) {
        String input="Hello, my name is john";
        System.out.println(countSegment(input));
    }

    //solution 1 :Iterative approach
    static int countSegment(String s){ //Tc O(n) AS:0(n)
        if (s==null || s.trim().isEmpty()) return 0;

        String [] segments=s.trim().split("\\s");

        return segments.length;
    }

    //solution two counting approach
    static int countSegmentSolutionTwo(String s){ //Tc 0(n) AS: 0(1)
        int count=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) !=' ' && (i==0 || s.charAt(i-1)==' '))
                count++;
        }
        return count;
    }
}
