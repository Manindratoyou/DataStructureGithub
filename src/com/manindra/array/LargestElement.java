package com.manindra.array;

public class LargestElement {

    public static void main(String[] args) {
        int [] arr={10,5,20,8};
        System.out.println(getLargestSolutionOne(arr));
        System.out.println(getLargestSolutionTwo(arr));
    }

    static int getLargestSolutionOne(int [] arr){ //O(n2) tc
        int n=arr.length;
        for (int i=0;i<arr.length;i++){
            boolean flag=true;
            for (int j=0;j<n;j++){
                if (arr[j]>arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag==true)
                return i;
        }
        return -1; //never comes here
    }

    static int getLargestSolutionTwo(int [] arr){ //Q(n) tc
        int result=arr[0];
        for (int i=0;i<arr.length;i++) {
            if (arr[i]>result)
                result=arr[i];
        }
        return result;
    }
}
