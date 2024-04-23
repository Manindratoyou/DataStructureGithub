package com.manindra.leetcodeMedium;

import java.util.ArrayList;
import java.util.List;

// Partition Labels
/*
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 */
public class Solution763 {

    public static void main(String[] args) {

        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    static List<Integer> partitionLabels(String str){

        List<Integer> partition=new ArrayList<>();

        for (int i=0;i<str.length();i++){

            //get first and last index of first character
            int startIndex=i;
            int endIndex=str.lastIndexOf(str.charAt(startIndex));

            for (int s=startIndex+1;s<=endIndex-1;s++){

                //find last index of any subsequent character
                int lastIndexOfNextChar=str.lastIndexOf(str.charAt(s));

                if (lastIndexOfNextChar>endIndex){
                    //update endIndex if required
                    endIndex=lastIndexOfNextChar;
                }
            }
            partition.add(endIndex-startIndex+1);
            //i=endIndex+1;
            // Increment i using a while loop
            while (i < endIndex) {
                i++;
            }
        }
        return partition;
    }

    public List<Integer> partitionLabelsSolutionTwo(String s) {
        List<Integer> result = new ArrayList<>();

        // Store the last occurrence index of each character
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // Iterate through the string to determine partition lengths
        int maxIndex = 0;
        int partitionStart = 0;
        for (int j = 0; j < s.length(); j++) {
            maxIndex = Math.max(maxIndex, lastOccurrence[s.charAt(j) - 'a']);
            if (maxIndex == j) { // Current index is the end of the current partition
                result.add(j - partitionStart + 1);
                partitionStart = j + 1; // Update partition start index
            }
        }

        return result;
    }
}
