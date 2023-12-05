package com.manindra.leetcodeMedium;

import java.math.BigInteger;

public class Solution43 { //multiply String

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
        String num3="987654321";
        String num4="987654321";
        System.out.println(multiply(num3,num4));
    }
    static String multiply(String num1, String num2) {

        BigInteger firstNumber=new BigInteger(num1);
        BigInteger secondNumber= new BigInteger(num2);

        BigInteger result=firstNumber.multiply(secondNumber);

        return result.toString();
    }
}