package com.manindra.leetcodeEasy;

public class DefuseTheBomb { //solution 1652

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result; // all zeros
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = Math.abs(k);
            int j = i;

            while (count-- > 0) {
                if (k > 0) {
                    j = (j + 1) % n; // move forward circularly
                } else {
                    j = (j - 1 + n) % n; // move backward circularly
                }
                sum += code[j];
            }

            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        int k = 2;

        int[] decrypted = decrypt(code, k);
        for (int val : decrypted) {
            System.out.print(val + " ");
        }
        // Output: 8 5 9 12
    }
}

