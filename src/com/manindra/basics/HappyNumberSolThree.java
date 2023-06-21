package com.manindra.basics;

/*
Time Complexity : 0(n*log(n))
Auxiliary space : 0(1)
 */
public class HappyNumberSolThree {

    public static void main(String[] args) {
        int n=13;
        if (isHappyNumber(n))
            System.out.println(n+ " is a Happy Number");
        else
            System.out.println(n+ " is not a Happy Number");
    }

    static boolean isHappyNumber(int n){
        if (n==1 || n==7)
            return true;
        int sum=n,x=n;
        while (sum>9){
            sum=0;

            //this loop finds the sum of square o digit
            while (x>0){
                int d=x%10;
                sum+=d*d;
                x/=10;
            }
            if (sum==1)
                return true;
            x=sum;
        }
        if (sum==7)
            return true;
        return false;
    }
}
