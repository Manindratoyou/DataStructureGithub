package com.manindra.hackerrank;

public class RemoveTrailingZeros {

    public static void main(String[] args) {

        String number="120300";
        System.out.println(removeTrailingZeros(number));
    }

    static String removeTrailingZeros(String num){
        int length=num.length();
        int i=length-1;

        //finding the first non-zero character from the end
        while (i>=0 && num.charAt(i)=='0'){
            i--;
        }
        //Building the resultant string
        StringBuilder sb=new StringBuilder(num.substring(0,i+1));
        return sb.toString();

    }
}
