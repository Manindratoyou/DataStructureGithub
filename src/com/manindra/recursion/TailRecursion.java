package com.manindra.recursion;

public class TailRecursion {

    public static void main(String[] args) {
      //  functionOne(3);
        System.out.println("==================");
       // functionOneTailRec(3,1);
        System.out.println(fact(3));
        System.out.println(factTailRecursion(3,1));
    }
    static void functionOne(int n){//not a tail recursion function
        if (n==0)
            return;
        functionOne(n-1);
        System.out.println(n);
    }
    static void functionOneTailRec(int n,int k){// tail recursion function
      if (n==0)
          return;
        System.out.println(k);
        functionOneTailRec(n-1,k+1);
    }

    static int fact(int n){
        if(n==0 || n==1)
            return 1;
        return n*fact(n-1);
    }
    static int factTailRecursion(int n,int k){
        if (n==0 || n==1)
            return k;
        return factTailRecursion(n-1,k*n);
    }

}
