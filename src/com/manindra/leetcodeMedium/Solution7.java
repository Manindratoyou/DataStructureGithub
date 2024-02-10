package com.manindra.leetcodeMedium;

public class Solution7 {

    //Input: x = 123
    //Output: 321
    public static void main(String[] args) {

        int input=123;
        System.out.println(reverse(input));
    }

    static int reverse(int x){

        int reverse=0;
        while (x!=0){
            int digit=x%10;
            if (reverse>Integer.MAX_VALUE/10 || reverse<Integer.MIN_VALUE/10)
                return 0;
            reverse=(reverse*10)+digit;
            x=x/10;
        }
        return reverse;
    }
}
