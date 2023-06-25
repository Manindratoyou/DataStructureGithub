package com.manindra.basics;

/*
Strong Number: 145 -> 1!+4!+5! -> 1+24+120->145
 */
public class StrongNumber {

    public static void main(String[] args) {
        System.out.println(isStrong(145));
    }

    static boolean isStrong(int number){
        int sum=0;
        int temp=number;
        while (temp!=0){
            int reminder=temp%10;
            sum+=factRecursive(reminder);
            temp=temp/10;
        }
        if (number==sum)
            return true;
        return false;
    }
    static int factRecursive(int n){
        if (n==0)
            return 1;
        return n*factRecursive(n-1);
    }
}
