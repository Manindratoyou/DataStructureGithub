package com.manindra.mathematics;

public class ComputingPower {

    public static void main(String[] args) {
        System.out.println(powerSolutionOne(3,4));
        System.out.println(powerSolutionTwo(3,4));
    }

    static int powerSolutionOne(int x,int n){
        int res=1;
        for (int i=0;i<n;i++){
            res=res*x;
        }
        return res;
    }
    static int powerSolutionTwo(int x,int n) {
        if (n==0)
            return 1;
        int temp=powerSolutionTwo(x,n/2);
        temp=temp*temp;
        if (n%2==0)
            return temp;
        else
            return temp*x;
    }
}
