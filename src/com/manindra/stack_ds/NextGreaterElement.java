package com.manindra.stack_ds;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {

        int [] arr={5,15,10,8,6,12,9,18};
        printGreater(arr);
        System.out.println();
        List<Integer> result=printGreaterStack(arr);
        System.out.println(result);
        System.out.println();
        int [] result2=printGreaterStackSolutionTwo(arr);
        System.out.println(Arrays.toString(result2));

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

    //leet code solution 503
    static int [] printGreaterStackSolutionTwo(int[] arr) { //works for circular array also

        /*int n= arr.length;
        int [] nge=new int[n];
        Stack<Integer> stack=new Stack<>();
        for (int i=2*n-1;i>=0;i--){
            while (stack.isEmpty()==false && stack.peek()<=arr[i%n])
                stack.pop();

            if (i<n){
                if (stack.isEmpty()==false)
                    nge[i]=stack.peek();
                else
                    nge[i]=-1;
            }
            stack.push(arr[i%n]);
        }
        return nge;*/
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (stack.isEmpty() == false && stack.peek() <= arr[i])
                stack.pop();

            if (stack.isEmpty() == false)
                nge[i] = stack.peek();
            else
                nge[i] = -1;

            stack.push(arr[i]);
        }
        return nge;
    }

}
