package com.manindra.leetcodeEasy;

import java.util.*;

public class SortThePeopleSolution2 {

    public static void main(String[] args) {

        String[] names = {"Marry", "John", "Emma"};
        int[] heights = {180, 165, 170};
        //String [] result=sortNamesByHeight(names,heights);
        String [] result=sortNamesByHeightSolutionThree(names,heights);
        System.out.println(Arrays.toString(result));
    }

    static String[] sortNamesByHeight(String[] names, int[] heights) {

        int n = names.length;
        Map<Integer, String> map = new HashMap<>();

        //create a map to heights to name
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        //sort the height in descending order
        Arrays.sort(heights);

        String[] result = new String[n];

        //fill the result [] with names in descending order of heights
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            result[index++] = map.get(heights[i]);
        }

        return result;
    }

    static String[] sortNamesByHeightSolutionThree(String[] names, int[] heights) {

        int n = names.length;
        TreeMap<Integer,String> map=new TreeMap<>(Collections.reverseOrder());

        //create a TreeMap of heights to names (automatically sorted in descending order)
        for (int i=0;i<n;i++){
            map.put(heights[i],names[i]);
        }

        String [] result=new String[n];

        //fill the result array with names in descending order of heights
        int index=0;
        for (Map.Entry<Integer,String> entry: map.entrySet()){
            result[index++]= entry.getValue();
        }
        return result;
    }
}
