package com.manindra.interview_2;

public class ShortestDistance {

    public static void main(String[] args) {
        String inputString = "the quick brown fox jumps over the lazy dog";
        String word1 = "fox";
        String word2 = "lazy";

        int distance = shortestDistance(inputString, word1, word2);

        if (distance != -1) {
            System.out.println("The shortest distance between \"" + word1 + "\" and \"" + word2 + "\" is: " + distance);
        } else {
            System.out.println("One or both words not found in the string.");
        }
    }

    public static int shortestDistance(String s, String word1, String word2) {
        String[] words = s.split("\\s+");
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

}

