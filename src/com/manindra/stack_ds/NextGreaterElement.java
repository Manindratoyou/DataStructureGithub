package com.manindra.stack_ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        int [] arr={5,15,10,8,6,12,9,18};
        printGreater(arr);
        System.out.println();
        List<Integer> result=printGreaterStack(arr);
        System.out.println(result);

    }

    static void printGreater(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    System.out.print(arr[j]+" ");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(-1);
            }
        }
    }

    static List<Integer> printGreaterStack(int[] arr) {

        List<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();

        stack.add(arr[arr.length-1]);

        list.add(-1);

        for (int i= arr.length-2;i>=0;i--){
            while (stack.isEmpty() ==false && stack.peek()<=arr[i]){
                stack.pop();
            }
            int nextGreater=stack.isEmpty() ? -1 : stack.peek();
            list.add(nextGreater);
            stack.add(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }

}
