package com.manindra.array_leetcode1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 { //largest number

    public static void main(String[] args) {

        int [] nums={3,30,34,5,9};
        System.out.println(largestNumber(nums)); //output : "9534330"

    }

    static String largestNumber(int [] nums){

        String [] arr=new String[nums.length];
        for (int i=0;i< nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }

        // Sort the String array in descending order
        /*Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arr));*/
        //sort the strings using custom comparator
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String order1=o1+o2;
                String order2=o2+o1;
                return order2.compareTo(order1);
            }
        });
        System.out.println(Arrays.toString(arr));

        //handles the case where the array consists of only zeros
        if(arr[0].equals("0"))
            return "0";

        //concatenate the sorted strings to form the largest number
        StringBuilder result=new StringBuilder();
        for (String s: arr)
            result.append(s);

        return result.toString();
    }

    static String largestNumberSolutionTwo(int [] nums){
        //converts integers to strings for easy comparison
        String [] arr=Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[] ::new);

        //sort the string using a lambda expression for comparator
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));

        //handle the case where the array consists of only zero
        if(arr[0].equals("0"))
            return "0";

        //concatenate the sorted strings to form the largest number

        return String.join("",arr);
    }
}
