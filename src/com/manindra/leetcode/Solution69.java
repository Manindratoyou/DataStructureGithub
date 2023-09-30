package com.manindra.leetcode;

public class Solution69 {

    public static void main(String[] args) {

        Solution69 solution69=new Solution69();

        int [] inputs={4,8,16,25,30};
        for (int input :inputs){
            int result= solution69.squareRoot(input);
            System.out.println("Square root of "+input +" is "+ result);
        }
    }

    //double R = Math.pow(X, 0.5);
    //double R = Math.sqrt(X);

    public int squareRoot(int x){
        if (x==0)
            return 0;
        long sqrt=x;//to avoid integer overflow
        while (sqrt*sqrt>x)
            sqrt=(sqrt+x/sqrt)/2;

        return (int) sqrt;
    }
    public int squareRootSolTwo(int x){
       if (x==0)
           return 0;

       int left=1;
       int right=x;

       while (left<=right){
           int mid=left+(right-left)/2;
           //avoid integer overflow by using (mid*mid <=x) instead of (mid <=x/mid)
           if (mid<=x/mid && (mid+1) >(x/mid+1)){
               return mid;
           } else if (mid>x/mid) {
               right=mid-1;
           }else
               left=mid+1;
       }
       return -1;//this line is not reachable ,but It's added to satisfy the compiler.
    }

}
