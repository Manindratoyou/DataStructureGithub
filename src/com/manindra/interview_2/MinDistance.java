package com.manindra.interview_2;

/*
The array is: ["a", "b", "c", "a", "d", "e", "c"]
The goal is to find the minimum distance between occurrences of the words "a" and "c".
The first occurrence of "a" is at index 0.
The first occurrence of "c" is at index 2.
The second occurrence of "a" is at index 3.
The second occurrence of "c" is at index 6.
Now, we calculate the distances between occurrences:

Distance between the first "a" and "c" is |2 - 0| = 2.
Distance between the second "a" and "c" is |6 - 3| = 3.
The minimum distance is 2.

Therefore, the expected output is: min_distance("a", "c") = 2.

 */
public class MinDistance {

    public static void main(String[] args) {
        //String[] words = {"a", "b", "c", "a", "d"};
        String[] words = {"a", "b", "c", "a", "d", "e", "c"};
        String word1 = "a";
        String word2 = "c";

        int distance = minDistance(word1, word2, words);
        System.out.println("min_distance('" + word1 + "', '" + word2 + "') = " + distance);
    }

    public static int minDistance(String word1, String word2, String[] words) {
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        minDist = Math.min(minDist, j - i);
                    }
                }
            }
        }
        return minDist;
    }

    /*
    example input:
["a", "b", "c", "a", "d"]

example output:
min_distance("a", "c") = 1

explanation:
"c" is in index 2 and "a" is in index 0 and 3. |3 - 2| = 1
     */

}

