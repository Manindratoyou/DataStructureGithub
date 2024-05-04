package com.manindra.leetcodeEasy;

public class GenerateStringWithOddCounts { //solution 1374

    public static void main(String[] args) {

        System.out.println(generateTheString(6));
    }

    static String generateTheString(int n) {

        StringBuilder sb = new StringBuilder();

        //if n is odd ,add n 'a' s
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }

        //if n is even ,add (n-1) 'a's and 1 'b'
        else {
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        }
        return sb.toString();
    }
}
