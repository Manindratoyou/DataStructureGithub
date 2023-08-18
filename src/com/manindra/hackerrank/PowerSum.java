package com.manindra.hackerrank;

public class PowerSum {

    /*
    100,2
    Output=3 :100=(10^2) ,(6^2+8^2),(1^2+3^2+4^2+5^2+7^2)
     */
        public static int powerSum(int x, int n) {
            return powerSumHelper(x, n, 1);
        }

        private static int powerSumHelper(int x, int n, int num) {
            int value = (int) (x - Math.pow(num, n));
            if (value == 0) {
                return 1;
            } else if (value < 0) {
                return 0;
            } else {
                return powerSumHelper(x, n, num + 1) + powerSumHelper(value, n, num + 1);
            }
        }

        //this is for different solution like
    //50 = 1^2 + 3^2 + 4^2 output will be 3
    public static int powerSumSolTwo(int x, int n) {
        int maxPower = (int) Math.pow(x, 1.0 / n);
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= maxPower; i++) {
            int power = (int) Math.pow(i, n);
            for (int j = x; j >= power; j--) {
                dp[j] += dp[j - power];
            }
        }
        return dp[x];
    }

        public static void main(String[] args) {
            int x = 50;
            int n = 2;
            //int result = powerSum(x, n);
            int result = powerSumSolTwo(x, n);
            System.out.println("Output: " + result);
        }

        /*
        Solution one
Example 1:
Input: x = 13, n = 2
Output: 1
Explanation: 13 can be represented as (2^2 + 3^2), so the minimum number of powers needed is 1.

Example 2:
Input: x = 25, n = 2
Output: 2
Explanation: 25 can be represented as (3^2 + 4^2), or as (5^2), so the minimum number of powers needed is 2.

Example 3:
Input: x = 64, n = 3
Output: 1
Explanation: 64 can be represented as (4^3), so the minimum number of powers needed is 1.

Example 4:
Input: x = 50, n = 2
Output: 2
Explanation: 50 can be represented as (1^2 + 7^2), or as (5^2 + 5^2), so the minimum number of powers needed is 2.

Example 5:
Input: x = 125, n = 3
Output: 1
Explanation: 125 can be represented as (5^3), so the minimum number of powers needed is 1.

  */

}
