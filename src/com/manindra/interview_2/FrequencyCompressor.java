package com.manindra.interview_2;

public class FrequencyCompressor {

    public static void main(String[] args) {
        test("ffaggghsssaaagggaaaaagggaa");  // Expected: f2a1g3h1s3a3g3a5g3a2
        test("a");                            // Expected: a1
        test("aaaaa");                        // Expected: a5
        test("abc");                          // Expected: a1b1c1
        test("aaabbbcccaaa");                 // Expected: a3b3c3a3
        test("");                             // Expected: (empty output)
        test("zzzyyyx");                      // Expected: z3y3x1
    }

    static void test(String input) {
        String result = compressFrequency(input);
        System.out.println("Input:    " + input);
        System.out.println("Output:   " + result);
        System.out.println();
    }

    static String compressFrequency(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                sb.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        // Append the last group
        sb.append(input.charAt(input.length() - 1)).append(count);

        return sb.toString();
    }
}

