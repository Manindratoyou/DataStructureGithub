package com.manindra.array_leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution14 { //Longest Common Prefix

    public static void main(String[] args) {

        String[] strings = {"flower", "flow", "flight"};
        String[] strings1 = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
        System.out.println(longestCommonPrefixSolutionTwo(strings1));
    }

    public static String longestCommonPrefix(String[] strs) {

        int size = strs.length;
        if (size == 0)
            return "";
        if (size == 1)
            return strs[0];
        //sort the array of string
        Arrays.sort(strs);

        //find the minimum length from first and last string
        int end = Math.min(strs[0].length(), strs[size - 1].length());

        //find the common prefix between the first and last string
        int i = 0;
        while (i < end && strs[0].charAt(i) == strs[size - 1].charAt(i))
            i++;

        String pre = strs[0].substring(0, i);
        return pre;
    }

    public static String longestCommonPrefix1(List<String> arr) {

        int size = arr.size();
        if (size == 0)
            return "";
        if (size == 1)
            return arr.get(0);
        //sort the array of string
        Collections.sort(arr);

        //find the minimum length from first and last string
        int end = Math.min(arr.get(0).length(), arr.get(size - 1).length());

        //find the common prefix between the first and last string
        int i = 0;
        while (i < end && arr.get(0).charAt(i) == arr.get(size - 1).charAt(i))
            i++;

        String pre = arr.get(0).substring(0, i);
        return pre;
    }

    public static String longestCommonPrefixSolutionTwo(String[] strs) {


        StringBuilder result = new StringBuilder();

        //sort the array
        Arrays.sort(strs);

        //get the first and last string
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i])
                break;
            result.append(first[i]);
        }
        return result.toString();
    }

    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Sort the array
        Arrays.sort(strs);

        // Compare the first and last strings in the sorted array
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;

        // Find the common prefix between the first and last string
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        // Return the prefix
        return first.substring(0, i);
    }
    public static String longestCommonPrefix4(List<String> arr) { //solution from CommonChars leetcode 1002
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : arr) {
            int[] freq = new int[26];
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Update min frequency
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result.toString();
    }
}
