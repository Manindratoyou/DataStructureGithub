package com.manindra.leetcode;

import java.util.TreeSet;

public class Solution414 { //third max

    public static void main(String[] args) {
        int [] num1={3,2,1,6,9,32};
        int [] num2={1,2};
        int [] num3={2,2,3,1};
        //System.out.println(thirdMax(num1));
        //System.out.println(thirdMax(num2));

        System.out.println(thirdMaxSolutionTwo(num1));
        System.out.println(thirdMaxSolutionTwo(num3));
    }

    static int thirdMax(int [] nums){

        TreeSet<Integer> set=new TreeSet<>((a,b)->b-a);
        for (int num : nums)
            set.add(num);
        if (set.size()<3)
            return set.first();
        set.pollFirst();
        set.pollFirst();

        return set.first();
    }

    static int thirdMaxSolutionTwo(int [] nums){

        Integer firstMax=null;
        Integer secondMax=null;
        Integer thirdMax=null;

        for (Integer num : nums){
            //1. skip duplicates
            if (num.equals(firstMax) ||num.equals(secondMax) || num.equals(thirdMax))
                continue;

            //2. update top three maximum number
            if (firstMax==null || num>firstMax){
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax=num;
            } else if (secondMax==null || num>secondMax) {
                thirdMax=secondMax;
                secondMax=num;
            } else if (thirdMax==null || num>thirdMax) {
                thirdMax=num;
            }
        }
        //3. return result
        return thirdMax!=null ? thirdMax :firstMax;
    }
    static int thirdHighest(int [] arr){
        int firstHighest=0;
        int secondHighest=0;
        int thirdHighest=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstHighest) {
                thirdHighest = secondHighest;
                secondHighest = firstHighest;
                firstHighest = arr[i];
            } else if (arr[i] > secondHighest) {
                thirdHighest = secondHighest;
                secondHighest = arr[i];
            } else if (arr[i] > thirdHighest) {
                thirdHighest = arr[i];
            }
        }
        System.out.println(firstHighest);
        System.out.println(secondHighest);
        System.out.println(thirdHighest);

        return thirdHighest;
    }
}
