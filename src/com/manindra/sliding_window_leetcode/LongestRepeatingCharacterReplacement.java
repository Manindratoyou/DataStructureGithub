package com.manindra.sliding_window_leetcode;

public class LongestRepeatingCharacterReplacement { // Solution 424

    public static void main(String[] args) {
        // Test Cases
        System.out.println(characterReplacement("AABABBA", 1)); // Output: 4
        System.out.println(characterReplacement("ABAB", 2));    // Output: 4
        System.out.println(characterReplacement("AABCAB", 2));  // Output: 4
        System.out.println(characterReplacement("AAAA", 2));    // Output: 4
        System.out.println(characterReplacement("ABCD", 1));    // Output: 2
    }

    //sliding window
    static int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // Frequency array for 'A' to 'Z'
        int left = 0, maxFreq = 0, maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update the frequency of the current character
            freq[s.charAt(right) - 'A']++;

            // Update the max frequency in the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowLength = right - left + 1;

            // If the number of characters to change (windowLength - maxFreq) is greater than k, shrink window
            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++; // Move left pointer to reduce window size
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }

    //binary search + sliding window
    static int characterReplacement2(String s, int k) {
        int left = 1, right = s.length(), ans = 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValid(s, mid, k)) {
                ans = mid; // Update answer if a valid window is found
                left = mid + 1; // Search for a bigger window
            } else {
                right = mid - 1; // Reduce window size
            }
        }
        return ans;
    }

    static boolean isValid(String s, int windowSize, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            if (right - left + 1 > windowSize) {
                freq[s.charAt(left) - 'A']--; // Shrink the window
                left++;
            }

            // If the number of replacements needed is within `k`, return true
            if (windowSize - maxFreq <= k) {
                return true;
            }
        }
        return false;
    }
}
