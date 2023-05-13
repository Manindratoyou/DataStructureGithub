package com.manindra.mathematics;

public class LCM {

    public static void main(String[] args) {

        System.out.println(lcmSolOne(4,6));
        System.out.println(lcmSolTwo(4,6));
    }

    static int lcmSolOne(int a ,int b){
        int res=Math.max(a,b);

        while (true){
            if (res%a==0 && res%b==0)
                return res;
            res++;
        }
    }

    //second approach
    static int lcmSolTwo(int a ,int b){

        return (a*b)/gcd(a,b);//ex (4*6)/2

    }
    static int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }
}
