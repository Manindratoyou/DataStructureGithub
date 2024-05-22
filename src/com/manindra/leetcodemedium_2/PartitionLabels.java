package com.manindra.leetcodemedium_2;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels { //solution 763

    public static void main(String[] args) {

        String s= "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    static List<Integer> partitionLabels(String str) {

        List<Integer> partitions = new ArrayList<>();

        for (int i = 0; i < str.length(); ) {

            //Get first abd last index of first character
            int startIndex = i;
            int endIndex = str.lastIndexOf(str.charAt(startIndex));

            for (int s = startIndex + 1; s <= endIndex - 1; s++) {

                //find last index of any subsequent characters
                int lastIndexOfNextChar = str.lastIndexOf(str.charAt(s));

                if (lastIndexOfNextChar > endIndex) {
                    //update endIndex if required
                    endIndex = lastIndexOfNextChar;
                }
            }
            partitions.add(endIndex - startIndex + 1);
            i = endIndex + 1;
        }
        return partitions;
    }
}
