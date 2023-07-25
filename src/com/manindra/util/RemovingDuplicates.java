package com.manindra.util;

import java.util.*;

public class RemovingDuplicates {

    public static void main(String[] args) {
        int [] arr={6,6,9,9,9,12,12};
        //int n=solutionOne(arr);
        /*int n=solutionTwo(arr);
        for (int i=0;i<n;i++)
            System.out.print(arr[i] +" ");*/
        //solutionThree(arr);
        //solutionFour(arr);
        solutionFive(arr);
    }

    //using extra space,works only for sorted array
    static int solutionOne(int [] arr){ //Time Complexity 0(n) Auxiliary Space 0(n)
        int [] temp=new int[arr.length];
        int j=0;
        for (int i=0;i< arr.length-1;i++){
            if (arr[i] !=arr[i+1])
                temp[j++]=arr[i];
        }
        temp[j++]=arr[arr.length-1];//coping the last element
        for (int i=0;i<j;i++)
            arr[i]=temp[i];
        return j;
    }
    //constant extra space ,approach is applicable when array is sorted
    static int solutionTwo(int [] arr){ //Time Complexity 0(n) Auxiliary Space 0(1)
       int j=0;
       for (int i=0;i< arr.length-1;i++){
           if (arr[i] !=arr[i+1])
               arr[j++]=arr[i];
       }
       arr[j++]=arr[arr.length-1];
       return j;
    }

    //for sorted and unsorted array both
    static void solutionThree(int [] arr){ //Time Complexity 0(n) Auxiliary Space 0(n)
        Set<Integer> set=new LinkedHashSet<>();
        for (int i=0;i< arr.length;i++)
            set.add(arr[i]);
        System.out.print(set);
    }

    //using frequency array,works for both sorted and unsorted array
    static void solutionFour(int [] arr){ //Time Complexity 0(n) Auxiliary Space 0(m)

        //m will have the maximum element in the array
        int m=0;
        for (int i=0;i< arr.length;i++){
            m=Math.max(m,arr[i]);
        }
        //creating the frequency array
        int [] f=new int[m+1];
        //incrementing the value at arr[i]th index in the frequency array
        for (int i=0;i< arr.length;i++)
            f[arr[i]]++;
        for (int i=0;i<m+1;i++){
            //if the frequency of the particular element is greater than 0 ,then print it once
            if (f[i]>0)
                System.out.print(i +" ");
        }
    }

    //using map ,used for both sorted and unsorted array
    static void solutionFive(int [] arr){ //Time Complexity 0(n)
        Map<Integer,Boolean> map=new HashMap<>();
        for (int i=0;i< arr.length;i++){
            if (map.get(arr[i])==null){
                System.out.print(arr[i]+" ");
                map.put(arr[i],true);
            }
        }
    }

}
