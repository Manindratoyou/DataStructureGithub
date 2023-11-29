package com.manindra.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution509 { //Fibonacci Number

    public static void main(String[] args) {

        int n=9;
        System.out.println("Fibonacci Series");
        for (int i=0;i<=n;i++){
            int fibonacciNumber=fibonacci(i);
            System.out.print(fibonacciNumber+" ");
        }
        System.out.println();
        System.out.println(fibSolutionTwo(9));
        System.out.println(fibSolutionThree(9));

    }

    //solution one
    static int fibonacci(int n){
        if (n<=1) return n;
        else return fibonacci(n-1)+fibonacci(n-2);
    }

    //solution 2
    static int fibSolutionTwo(int n){
        //easy base case/edge case
        if (n<=1) return n;

        //initialize our base case
        //size N+1 so that we can accommodate from 0 to N
        int [] map=new int[n+1];

        //put out base case
        map[0]=0;
        map[1]=1;

        //iterate through remaining values (2...N)
        for (int i=2;i<=n;i++){
            map[i]=map[i-1]+map[i-2];
        }
        return map[n];
    }

    //solution three
    private static Map<Integer,Integer> memo=new HashMap<>();
    public static int fibSolutionThree(int n){
        if (n<=1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int result=fibSolutionThree(n-1)+fibSolutionThree(n-2);
        memo.put(n,result);
        return result;
    }
}
