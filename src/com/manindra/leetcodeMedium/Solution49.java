package com.manindra.leetcodeMedium;

import java.util.*;

/*
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Solution49 { //Group Anagrams

    public static void main(String[] args) {

        String s = "abbca";
        System.out.println(countCharactersFrequency(s));

        String[]  strs= {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramByFrequency(strs));
    }


    static List<List<String>> groupAnagramByFrequency(String [] strs){
        if (strs==null ||strs.length==0) return new ArrayList<>();

        Map<String,List<String>> map=new HashMap<>();
        for (String str:strs) {
            //String frequencyString=countCharactersFrequency(str); some test case is failing
            String frequencyString=getFrequencyString(str);
            //if the frequency string is present ,add the string to the list
            if (map.containsKey(frequencyString)){
                map.get(frequencyString).add(str);
            }else {
                //create a new list
                List<String> stringList=new ArrayList<>();
                stringList.add(str);
                map.put(frequencyString,stringList);
            }
        }
        return new ArrayList<>(map.values());
    }

    static String getFrequencyString(String str) {

        // Frequency buckets
        int[] freq = new int[26];

        // Iterate over each character
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        // Start creating the frequency string
        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for (int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }

        return frequencyString.toString();
    }

    public static String countCharactersFrequency(String s) {
        // Create a map to store the count of each character
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Iterate through the characters in the string
        for (char c : s.toCharArray()) {
            // Update the count in the map
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            result.append(entry.getKey());
            result.append(entry.getValue());
        }

        return result.toString();
    }

    //solution two

    public List<List<String>> groupAnagramsCategorizeBySorting(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> stringAnagramsMap = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (!stringAnagramsMap.containsKey(key))
                stringAnagramsMap.put(key, new ArrayList<>());

            stringAnagramsMap.get(key).add(s);
        }

        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet()) {
            resultList.add(stringAnagrams.getValue());
        }
        return resultList;
    }

}
