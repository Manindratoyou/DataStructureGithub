package com.manindra.basics;

public class ArmstrongNumber {

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(3%10);
        System.out.println(3/10);
    }

    static boolean isArmstrong(int number){
        int countDigit=numberOfDigit(number);
        int temp=number,sum=0;
        while (temp>0){
            int reminder=temp%10;
            sum= (int) (sum+Math.pow(reminder,countDigit));
            temp=temp/10;
        }
        return sum==number;
    }

    static int numberOfDigit(int number){
        int count=0;
        while (number>0){
            count++;
            number=number/10;
        }
        return count;
    }
}
