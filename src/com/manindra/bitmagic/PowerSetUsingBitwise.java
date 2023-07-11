package com.manindra.bitmagic;

public class PowerSetUsingBitwise {
    public static void main(String[] args) {
        String s="abc";int n=3; //2^3=8
        printPowerSet(s);
    }

    static void printPowerSet(String s){
        int n=s.length();
        int pSize=(1<<n);
        for (int i=0;i<pSize;i++){
            for (int j=0;j<n;j++)
                if ((i & (1<<j))!=0)
                    System.out.println(s.charAt(j));
            System.out.println();
        }
    }
}
