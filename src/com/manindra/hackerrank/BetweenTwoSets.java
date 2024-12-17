package com.manindra.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetweenTwoSets {

    public static void main(String[] args) {
        BetweenTwoSets betweenTwoSets = new BetweenTwoSets();

        // Test Case 1
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(16, 32, 96));
        int result1 = betweenTwoSets.getTotalX(list1, list2);
        System.out.println("Test Case 1 Result: " + result1);

        // Test Case 2
        List<Integer> list3 = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(24, 48));
        //int result2 = betweenTwoSets.getTotalX(list3, list4);
        int result2 = betweenTwoSets.getTotalX2(list3, list4);
        System.out.println("Test Case 2 Result: " + result2);
    }

    int getGCD(int n1, int n2) {
        if (n2 == 0) return n1;
        return getGCD(n2, n1 % n2);
    }

    int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0) return 0;
        else {
            int gcd = getGCD(n1, n2);
            return Math.abs(n1 * n2) / gcd;
        }
    }

    public int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;

        //get LCM of all elements of a
        int lcm = a.get(0);
        for (Integer integer : a)
            lcm = getLCM(lcm, integer);

        //get GCD of all element of b
        int gcd = b.get(0);
        for (Integer integer : b)
            gcd = getGCD(gcd, integer);

        //count multiple of lcm that divides the gcd
        int multiple = 0;
        while (multiple <= gcd) {
            multiple += lcm;

            if (gcd % multiple == 0)
                result++;
        }
        return result;
    }

    public int getTotalX2(List<Integer> a, List<Integer> b) {
        int first = a.get(a.size() - 1);
        int last = b.get(0);
        List<Integer> al = new ArrayList<>();
        for (int i = first; i <= last; i++) {
            int count = 0;
            for (int j = 0; j < a.size(); j++) {
                if (i % a.get(j) == 0)
                    count++;
                else
                    break;
            }
            if ((count == a.size()))
                al.add(i);
        }
        int ans = 0;
        for (int i = 0; i < al.size(); i++) {
            int count = 0;
            for (int j = 0; j < b.size(); j++) {
                if (b.get(j) % al.get(i) == 0)
                    count++;
                else
                    break;
            }
            if (count == b.size())
                ans++;
        }
        return ans;
    }

}
