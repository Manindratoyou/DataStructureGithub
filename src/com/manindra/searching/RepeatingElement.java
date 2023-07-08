package com.manindra.searching;

import java.util.Arrays;

/*
Array size n>=2
only one element repeats(Any Number of Times)
All the elements from 0 to max(array) are present
therefor 0<=max(array) <=n-2
 */
public class RepeatingElement {

    public static void main(String[] args) {

        int [] arr={0,2,1,3,2,2}; //op 2
        int [] arr1={1,2,3,0,3,4,5}; //op 3
        System.out.println(repeatingElementSolOneSuperNaive(arr));
        System.out.println(repeatingElementSolTwoNaive(arr));
        System.out.println(repeatingElementSolThreeEfficient(arr));

    }

    static int repeatingElementSolOneSuperNaive(int [] arr){ //tc O(n2) AS O(1)
        for(int i=0;i<arr.length-1;i++)
            for (int j=i+1;j<arr.length;j++)
                if (arr[i]==arr[j])
                    return arr[i];
        return -1;
    }
    static int repeatingElementSolTwoNaive(int [] arr){ //tc O(nlogn) AS O(1)
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
            if (arr[i]==arr[i+1])
                return arr[i];
        return -1;
    }
    static int repeatingElementSolThreeEfficient(int [] arr){ //tc O(nlogn) AS O(1)
        boolean [] visited=new boolean[arr.length];
        for (int i=0;i<arr.length;i++){
            if (visited[arr[i]]) {
                return arr[i];
            }
            visited[arr[i]]=true;
        }
        return -1;
    }
}
