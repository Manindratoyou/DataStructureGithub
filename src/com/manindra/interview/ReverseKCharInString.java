package com.manindra.interview;

public class ReverseKCharInString {

    public static void main(String[] args) {

        String s = "manindra";
        int k = 3;
        // op-namdniar
        String reversed = reverseK(s, k);
        System.out.println(reversed); // Output: namdniar
    }

    public static String reverseK(String str, int k) {
        // Convert the string to char arrayw
        char[] charArray = str.toCharArray();

        // Traverse the string
        for (int i = 0; i < charArray.length; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, charArray.length - 1); // Handle the case when the length of the remaining string is less than k

            // Reverse the substring of length k
            while (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }

        // Convert the char array back to string
        return new String(charArray);
    }

    public static String reverseKSolutionTwo(String str, int k) {
        StringBuilder result = new StringBuilder();

        // Iterate through the string with a step of k
        for (int i = 0; i < str.length(); i += k) {
            // Get the substring of length k
            String sub = str.substring(i, Math.min(i + k, str.length()));

            // Reverse the substring
            StringBuilder subReversed = new StringBuilder(sub).reverse();

            // Append the reversed substring to the result
            result.append(subReversed);
        }

        return result.toString();
    }
}
