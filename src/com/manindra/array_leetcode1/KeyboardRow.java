package com.manindra.array_leetcode1;

import java.util.*;

public class KeyboardRow { //solution 500

    //Input: words = ["Hello","Alaska","Dad","Peace"]
    //Output: ["Alaska","Dad"]
    public static void main(String[] args) {

        String s = "qwertyuiop";
        String s1 = "asdfghjkl";
        String s2 = "zxcvbnm";

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = findWords(words);
        System.out.println(Arrays.toString(result));

    }

    static String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();

        Set<Character> row1 = new HashSet<>(Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M'));

        for (String word : words) {
            if (isInSameRow(word.toUpperCase(), row1)
                    || isInSameRow(word.toUpperCase(), row2)
                    || isInSameRow(word.toUpperCase(), row3)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    static boolean isInSameRow(String word, Set<Character> row) {
        for (char c : word.toCharArray()) {
            if (!row.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public String[] findWordsSolTwo(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        LinkedList<String> list = new LinkedList<>();

        for (String word : words) {
            int[] rows = new int[3];
            for (char ch : word.toLowerCase().toCharArray()) {
                if (row1.indexOf(ch) != -1)
                    rows[0] = 1;
                else if ((row2.indexOf(ch) != -1))
                    rows[1] = 1;
                else if ((row3.indexOf(ch) != -1))
                    rows[2] = 1;
            }
            int sum = rows[0] + rows[1] + rows[2];
            if (sum == 1)
                list.add(word);
        }

        String[] arr = new String[list.size()];
        int i = 0;

        for (String word : list)
            arr[i++] = word;

        return arr;

    }

}

