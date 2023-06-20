package com.manindra.basics;

public class ArmstrongNumberUsingNumericString {

    public static void main(String[] args) {
        isArmstrong("153");
        isArmstrong("1253");
    }

    static void isArmstrong(String number){
        char[] chars=number.toCharArray();
        int size= chars.length;
        int sum=0;

        for (char num : chars){
            int temp=1;
            int i=Integer.parseInt(Character.toString(num));

            for (int j=0;j<=size-1;j++){
                temp*=i;
            }
            sum+=temp;
        }
        if (sum==Integer.parseInt(number))
            System.out.println("True");
        else
            System.out.println("False");

    }
}
