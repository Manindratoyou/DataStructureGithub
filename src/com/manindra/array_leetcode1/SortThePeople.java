package com.manindra.array_leetcode1;

import java.util.Arrays;

public class SortThePeople {  //solution 2418

    public static void main(String[] args) {

        String[] names = {"Marry", "John", "Emma"};
        int[] heights = {180, 165, 170};
        String [] result=sortNamesByHeight(names,heights);
        System.out.println(Arrays.toString(result));


    }

    static String[] sortNamesByHeight(String[] names, int[] heights) {

        int n = names.length;
        //create an array of pairs to store names and height together
        Pair[] people = new Pair[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Pair(names[i], heights[i]);
        }

        //sort the array of pairs in descending order based on height
        Arrays.sort(people, (a, b) -> b.height - a.height);

        //extract name from the sorted arrays
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = people[i].name;
        }
        return result;

    }


    static class Pair {

        String name;
        int height;

        public Pair(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
