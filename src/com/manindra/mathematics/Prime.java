package com.manindra.mathematics;

public class Prime {

    public static void main(String[] args) {

        System.out.println(isPrimeSolutionOne(7));
        System.out.println(isPrimeSolutionTwo(127));
        System.out.println(isPrimeSolutionThree(1031));
        //printPrimes(10);
    }

    //solution one (Q7 Notes)
    static boolean isPrimeSolutionOne(int n){ //O(n)-time complexity
        if (n==1)
            return false;
        for (int i=2;i<n;i++){
            if (n%i==0)
                return false;
        }
        return true;
    }

    /*
    30 : (1,30),(2,15),(3,10),(5,6)

    if(x,y) is a pair and x*y=n
    and if x<=y
    x*x<=n
    x<=Sqrt(n)

     */
    static boolean isPrimeSolutionTwo(int n){ //O(sqrt(n))-time complexity
        if (n==1)
            return false;
        for (int i=2;i*i<n;i++){ //for (int i=2;i<Math.sqrt(n);i++){
            if (n%i==0)
                return false;
        }
        return true;
    }

    //more efficient solution
    static boolean isPrimeSolutionThree(int n){
        if (n==1)
            return false;
        if (n==2 || n==3)
            return true;
        if (n%2==0 || n%3==0)
            return false;
        for (int i=5;i*i<n;i=i+6){
            if (n%i==0 ||n%(i+2)==0)
                return false;
        }
        return true;
    }


    //print prime number from 1 to n(q10)
    static void printPrimes(int n){
        for (int i=2;i<n;i++){
            if (isPrimeSolutionOne(i))
                System.out.print(i +" ");
        }
    }
}
