package com.manindra.hackerrank;

public class ChocolateFeast {

    public static void main(String[] args) {
        // Test cases
        System.out.println(chocolateFeast(15, 3, 2));  // Output: 9
        System.out.println(chocolateFeast(10, 2, 5)); // Output: 6
        System.out.println(chocolateFeast(12, 4, 4)); // Output: 3
        System.out.println(chocolateFeast(6, 2, 2));  // Output: 5
    }

    public static int chocolateFeast(int n, int c, int m) {
        // Initial chocolates purchased
        int chocolates = n / c;
        int wrappers = chocolates;

        // Wrapper redemption
        while (wrappers >= m) {
            int extraChocolates = wrappers / m;
            chocolates += extraChocolates;
            wrappers = wrappers % m + extraChocolates; // Remaining wrappers + new wrappers
        }

        return chocolates;
    }

    public static int chocolateFeast2(int n, int c, int m) {

        //no of chocolate
        int num = n / c;
        int wrapper = num;
        if (wrapper < m) {
            return num;
        } else {
            while (wrapper >= m) {
                num = num + 1;
                wrapper = wrapper - m + 1;
            }
        }
        return num;

    }

}

