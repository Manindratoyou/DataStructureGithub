package com.manindra.recursion;

public class RopeCuttingProblemRec {

    public static void main(String[] args) {

        int n = 23, a = 11, b = 9, c = 12;
        System.out.println(maxCuts(n, a, b, c));
    }

    static int maxCuts(int n, int a,int b,int c){
        if (n==0)
            return 0;
        if (n<0)
            return -1;
        int res = Math.max(maxCuts(n-a, a, b, c),
                  Math.max(maxCuts(n-b, a, b, c),
                        maxCuts(n-c, a, b, c)));
        if(res == -1)
            return -1;

        return res + 1;
    }
}
