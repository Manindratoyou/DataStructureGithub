package com.manindra.array_leetcode1;
/*
Input: operations = ["--X","X++","X++"]
Output: 1
Explanation: The operations are performed as follows:
Initially, X = 0.
--X: X is decremented by 1, X =  0 - 1 = -1.
X++: X is incremented by 1, X = -1 + 1 =  0.
X++: X is incremented by 1, X =  0 + 1 =  1
 */
public class Solution2011 {

    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        int finalValue = finalValueAfterOperations(operations);

        System.out.println("Final Value: " + finalValue);
    }

    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                result++;
            } else {
                result--;
            }
        }

        return result;
    }

}
