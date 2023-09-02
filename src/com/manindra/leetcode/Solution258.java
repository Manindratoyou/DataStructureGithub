package com.manindra.leetcode;

public class Solution258 {

    public int addDigit(int number){

        if (number==0) return 0;

        else if (number%9==0)  return 9;

        else return number%9;
    }

    public int addDigitSolutionTwo(int number){
        while (number>=10){
            int sum=0;
            while (number>0){
                sum+=number%10;
                number/=10;
            }
            number=sum;
        }
        return number;
    }

    public static void main(String[] args) {

        Solution258 solution=new Solution258();
        System.out.println(solution.addDigit(38));
        System.out.println(solution.addDigit(0));
        System.out.println(solution.addDigit(9));
        System.out.println(solution.addDigit(123));
        System.out.println("=");
        Solution258 solution1=new Solution258();
        System.out.println(solution1.addDigitSolutionTwo(38));
        System.out.println(solution1.addDigitSolutionTwo(0));
        System.out.println(solution1.addDigitSolutionTwo(9));
        System.out.println(solution1.addDigitSolutionTwo(123));
    }
}
