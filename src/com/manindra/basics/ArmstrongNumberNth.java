package com.manindra.basics;

public class ArmstrongNumberNth {

    public static void main(String[] args) {
        System.out.println(isArmstrong(10));
    }

    static int isArmstrong(int start){
        int count=0;
        for (int i=1;i<=Integer.MAX_VALUE;i++) {
            int countDigit = numberOfDigit(i);
            int temp = i, sum = 0;
            while (temp > 0) {
                int reminder = temp % 10;
                sum = (int) (sum + Math.pow(reminder, countDigit));
                temp = temp / 10;
            }
            if (sum==i)
                count++;
            if (count==start)
                return i;
        }
        return start;
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
