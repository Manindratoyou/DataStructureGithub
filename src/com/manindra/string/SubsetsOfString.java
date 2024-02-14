package com.manindra.string;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfString {

    public static void main(String[] args) {
        String input = "abc";
        List<String> subsets = generateSubsets(input);

        // Print the generated subsets
        System.out.println("Subsets of '" + input + "': " + subsets);

        String input1 = "abc";
        List<String> subsets1 = SubsetsOfStringIterative(input1);

        // Print the generated subsets
        System.out.println("Subsets of '" + input1 + "': " + subsets1);


        //////////////////////////////////

        List<List<Character>> list2=subsets(input);//use this
        System.out.println(list2);

    }

    private static List<String> generateSubsets(String str) {
        List<String> subsets = new ArrayList<>();
        generateSubsetsHelper(str, 0, "", subsets);
        return subsets;
    }

    private static void generateSubsetsHelper(String str, int index, String currentSubset, List<String> subsets) {
        // Add the current subset to the list
        subsets.add(currentSubset);

        // Generate subsets by including the current character
        for (int i = index; i < str.length(); i++) {
            generateSubsetsHelper(str, i + 1, currentSubset + str.charAt(i), subsets);
        }
    }

    //solution two
    static List<String> SubsetsOfStringIterative(String str) {
        List<String> subsets = new ArrayList<>();
        int n = str.length();

        // Total number of subsets will be 2^n
        for (int i = 0; i < (1 << n); i++) {
            StringBuilder currentSubset = new StringBuilder();

            // Iterate through each bit of the binary representation
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    // If the j-th bit is set, include the corresponding character in the subset
                    currentSubset.append(str.charAt(j));
                }
            }

            // Add the current subset to the list
            subsets.add(currentSubset.toString());
        }

        return subsets;
    }

    public static List<List<Character>> subsets(String input) {
        List<List<Character>> resultList = new ArrayList<>();

        // Start backtracking from the beginning
        backtrack(resultList, new ArrayList<>(), input.toCharArray(), 0);
        return resultList;
    }

    static void backtrack(List<List<Character>> resultSets, List<Character> tempSet,
                          char[] inputChars, int start) {
        // Add the set to result set
        resultSets.add(new ArrayList<>(tempSet));
        for (int i = start; i < inputChars.length; i++) {

            // Case of including the character
            tempSet.add(inputChars[i]);

            // Backtrack the new subset
            backtrack(resultSets, tempSet, inputChars, i + 1);

            // Case of not-including the character
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
