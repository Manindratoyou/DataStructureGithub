package com.manindra.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
Explanation: If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
 */
public class Solution1431 { //Kids With the Greatest Number of Candies

    public static void main(String[] args) {

        int [] candies = {2,3,5,1,3}; int extraCandies = 3;
        List<Boolean> result=kidsWithCandies(candies,extraCandies);
        List<Boolean> result2=kidsWithCandiesSolTwo(candies,extraCandies);
        System.out.println(result);
        System.out.println(result2);
    }


    //using stream
    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = getMaxCandies(candies);
        return Arrays.stream(candies)
                .mapToObj(candy -> candy + extraCandies >= maxCandies)
                .collect(Collectors.toList());
    }

    static int getMaxCandies(int[] candies) {
        return Arrays.stream(candies).max().orElse(0);
    }

    //Solution 2: Using Iteration
    //Time Complexity: O(n) where n is the number of elements in the candies array.
    //Auxiliary Space: O(n) for the result list.
    static List<Boolean> kidsWithCandiesSolTwo(int[] candies, int extraCandies) {
        int maxCandies = getMaxCandiesSolTwo(candies);
        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    static int getMaxCandiesSolTwo(int[] candies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }
}
