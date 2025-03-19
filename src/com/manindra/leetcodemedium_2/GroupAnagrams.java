package com.manindra.leetcodemedium_2;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams { //solution 49

    public static void main(String[] args) {
        // Test cases
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {"abcd", "efgh", "dcba", "ghfe", "bacd", "efgh"};

        //List<List<String>> result1 = groupAnagramCategorizedBySorting(strs1);
        //List<List<String>> result2 = groupAnagramCategorizedBySorting(strs2);

        List<List<String>> result1 = groupAnagramCategorizedByFrequency(strs1);
        List<List<String>> result2 = groupAnagramCategorizedByFrequency(strs2);

        System.out.println(result1);
        System.out.println(result2);
    }

    static List<List<String>> groupAnagramCategorizedBySorting(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> stringAnagramMap = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (!stringAnagramMap.containsKey(key))
                stringAnagramMap.put(key, new ArrayList<>());

            stringAnagramMap.get(key).add(s);

        }

        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringAnagram : stringAnagramMap.entrySet()) {
            resultList.add(stringAnagram.getValue());
        }
        return resultList;
    }

    static List<List<String>> groupAnagramCategorizedByFrequency(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> frequencyStringMap = new HashMap<>();
        for (String str : strs) {
            String frequencyString = getFrequencyString(str);

            //if the frequency string is present ,add the string to the list
            if (frequencyStringMap.containsKey(frequencyString)) {
                frequencyStringMap.get(frequencyString).add(str);
            } else {
                //else create a new list
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(frequencyString, strList);
            }
        }

        return new ArrayList<>(frequencyStringMap.values());

    }

    static String getFrequencyString(String str) {

        //frequency bucket
        int[] freq = new int[26];

        //iterate over each character
        for (char c : str.toCharArray())
            freq[c - 'a']++;

        //start creating the frequency string
        StringBuilder frequencyString = new StringBuilder();
        char c = 'a';
        for (int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }

    //
    public static void streamSolution(String[] args) {

        String[] name={"eat","tea","tan","ate","Nat","bat"};
        List<String> convertList = Arrays.asList(name);
        Collection<List<String>> resultValue = convertList.stream().collect(Collectors
                .groupingBy(x -> Arrays.stream(x.toLowerCase().split(""))
                        .sorted().collect(Collectors.toList()))).values();


        System.out.println(resultValue);
    }

}
