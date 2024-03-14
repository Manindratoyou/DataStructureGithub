package com.manindra.leetcodemedium_2;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures { //solution739

    public static void main(String[] args) {

        int [] temperatures = {73,74,75,71,69,72,76,73};
        int [] result=dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }


    static int [] dailyTemperatures(int [] temperatures){

        Stack<Integer> helperStack=new Stack<>();
         int n= temperatures.length;
         int [] result=new int[n];

         for (int idx=n-1;idx>=0;idx--) {
             //popping all indices with a lower or equal
             //temperature than the current index

             while (!helperStack.isEmpty() && temperatures[idx] >= temperatures[helperStack.peek()]) {
                 helperStack.pop();
             }

             //if the stack still has elements then the next warmer temperature exists!
             if (!helperStack.isEmpty()) {
                 result[idx]=helperStack.peek()-idx;
             }
             //inserting current index in the stack
             helperStack.push(idx);
         }
         return result;
    }
}
