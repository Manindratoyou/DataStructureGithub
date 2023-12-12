package com.manindra.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
 */
public class Solution771 { //Jewels and Stones

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println("Number of jewels in stones: " + numJewelsInStonesSolutionTwo(J, S));
        System.out.println("Number of jewels in stones: " + numJewelsInStonesSolutionThree(J, S));
        System.out.println("Number of jewels in stones: " + numJewelsInStonesSolutionFour(J, S));
    }

    static int numJewelsInStonesSolutionOne(String jewels,String stones){

        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        for (char c: stones.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        for (char c: jewels.toCharArray()){
            if (map.containsKey(c))
                count+=map.get(c);
        }
        return count;
    }

    //Brute Force Time Complexity: O(m * n) Auxiliary Space: O(1)
    public static int numJewelsInStonesSolutionTwo(String J, String S) {
        int count = 0;

        for (char stone : S.toCharArray()) {
            if (J.indexOf(stone) != -1) {
                count++;
            }
        }

        return count;
    }

    //Time Complexity: O(m + n)
    //Auxiliary Space: O(m), where m is the number of jewels
    public static int numJewelsInStonesSolutionThree(String J, String S) {
        Set<Character> jewelSet = new HashSet<>();

        for (char jewel : J.toCharArray()) {
            jewelSet.add(jewel);
        }

        int count = 0;
        for (char stone : S.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }

        return count;
    }

    //using array Time Complexity: O(m + n) Auxiliary Space: O(1)
    public static int numJewelsInStonesSolutionFour(String J, String S) {
        boolean[] isJewel = new boolean[256]; // Assuming ASCII characters

        for (char jewel : J.toCharArray()) {
            isJewel[jewel] = true;
        }

        int count = 0;
        for (char stone : S.toCharArray()) {
            if (isJewel[stone]) {
                count++;
            }
        }

        return count;
    }

}
