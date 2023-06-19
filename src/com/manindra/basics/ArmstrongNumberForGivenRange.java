package com.manindra.basics;

public class ArmstrongNumberForGivenRange {

    public static void main(String[] args) {

        int initial=5,end=1000;
        isArmstrong(initial,end);

    }
    static void isArmstrong(int start, int end){
        for (int i=start;i<=end;i++) {
            int countDigit = numberOfDigit(i);
            int temp = i, sum = 0;
            while (temp > 0) {
                int reminder = temp % 10;
                sum = (int) (sum + Math.pow(reminder, countDigit));
                temp = temp / 10;
            }
            if (sum==i)
                System.out.print(i+" ");
        }

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
