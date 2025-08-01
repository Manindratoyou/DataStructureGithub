package com.manindra.array_leetcode1;

import java.util.*;

/*
Input: words = ["cd","ac","dc","ca","zz"]
Output: 2
Explanation: In this example, we can form 2 pair of strings in the following way:
- We pair the 0th string with the 2nd string, as the reversed string of word[0] is "dc" and is equal to words[2].
- We pair the 1st string with the 3rd string, as the reversed string of word[1] is "ca" and is equal to words[3].
It can be proven that 2 is the maximum number of pairs that can be formed.
 */
public class Solution2744 { //Find Maximum Number of String Pairs

    public static void main(String[] args) {

        String[] words = {"cd", "ac", "dc", "ca", "zz"};

        test(words);
        System.out.println("===========");
        System.out.println(findPairs(words));
        System.out.println(maximumNumberOfStringPairs2(words));
    }

    static void test(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s2 = new String(chars);
            map.put(s2, map.getOrDefault(s2, 0) + 1);
            System.out.println(s2);
        }
        System.out.println(map);
        int count = 0;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() > 1) {
                System.out.println(m.getKey());
                count++;
                System.out.println(count);
            }
        }
    }

    static int findPairs(String[] words) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder reversed = new StringBuilder(word).reverse();
            if (set.contains(reversed.toString())) {
                count++;
            }
            set.add(word);
        }
        return count;
    }

    public static int maximumNumberOfStringPairs2(String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            if (set.contains(rev)) {
                count++;
            } else {
                set.add(word);
            }
        }

        return count;
    }

    public static int maximumNumberOfStringPairs3(String[] words) { //brut force
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(0) == words[j].charAt(1) &&
                        words[i].charAt(1) == words[j].charAt(0)) {
                    count++;
                }
            }
        }
        return count;
    }

}
