package com.manindra.leetcodeEasy;

public class LargestOddNumberString { //solution 1903

    public static void main(String[] args) {

        String num="35427";
        //String num = "52";
        System.out.println(largestOddNumber(num));
    }

    static String largestOddNumber(String num) {
        int n = num.length();

        for (int i = n - 1; i >= 0; i--) {
            if ((num.charAt(i)-'0')%2 !=0)
                return num.substring(0,i+1);
        }
        return "";
    }
}
