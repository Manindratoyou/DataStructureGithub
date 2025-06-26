package com.manindra.hashing_leetcode;

import java.util.*;

public class UncommonWords { //solution 884

    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";

        String[] result = uncommonFromSentences(s1, s2);
        System.out.println(Arrays.toString(result));  // Output: [sweet, sour]
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : (s1 + " " + s2).split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        //String[] stringArray = stringList.toArray(new String[result.size()]);
        return result.toArray(new String[0]);
    }
}

