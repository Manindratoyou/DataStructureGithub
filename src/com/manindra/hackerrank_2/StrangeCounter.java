package com.manindra.hackerrank_2;

import java.io.IOException;

public class StrangeCounter {

    public static long strangeCounter(long t) {
        // cycle_start_value: Represents the initial value of the counter at the
        // beginning of the current cycle. It starts at 3 for the first cycle.
        long cycle_start_value = 3;

        // time_at_cycle_start: Represents the starting time 't' for the current cycle.
        // For the first cycle, it starts at t=1.
        long time_at_cycle_start = 1;

        // This loop finds the cycle that the given time 't' falls into.
        // It continues as long as 't' is greater than or equal to the time
        // at which the next cycle would begin (time_at_cycle_start + cycle_start_value).
        // Example: If current cycle starts at t=1 with value 3, it ends at t=3.
        // The next cycle would start at t=4.
        // So, if t >= 1 + 3 (i.e., t >= 4), 't' is in a subsequent cycle.
        while (t >= time_at_cycle_start + cycle_start_value) {
            // Update time_at_cycle_start to reflect the end of the current cycle
            // and effectively the beginning of the next cycle's time block.
            time_at_cycle_start += cycle_start_value;

            // Double the cycle_start_value for the next cycle, as per problem description.
            cycle_start_value *= 2;
        }

        // Once the loop finishes, 't' is within the current cycle defined by
        // `cycle_start_value` and `time_at_cycle_start`.

        // Calculate the offset of 't' from the beginning of its current cycle.
        // For example, if cycle starts at t=4 and current t=4, offset is 0.
        // If current t=5, offset is 1.
        long time_offset_in_current_cycle = t - time_at_cycle_start;

        // The value displayed by the counter at time 't' is the initial value
        // of this cycle minus the number of seconds that have passed since
        // the beginning of this cycle.
        return cycle_start_value - time_offset_in_current_cycle;
    }

    public static void main(String[] args) throws IOException {
        // --- Test Cases ---

        // Test Case 1: t = 1 (First cycle, first second)
        // Expected: 3
        System.out.println("Test Case 1: t = 1");
        System.out.println("Input: 1");
        System.out.println("Output: " + StrangeCounter.strangeCounter(1));
        System.out.println("Expected: 3");
        System.out.println("--------------------");

        // Test Case 2: t = 3 (First cycle, last second)
        // Expected: 1
        System.out.println("Test Case 2: t = 3");
        System.out.println("Input: 3");
        System.out.println("Output: " + StrangeCounter.strangeCounter(3));
        System.out.println("Expected: 1");
        System.out.println("--------------------");

        // Test Case 3: t = 4 (Second cycle, first second) - from problem statement
        // Expected: 6
        System.out.println("Test Case 3: t = 4");
        System.out.println("Input: 4");
        System.out.println("Output: " + StrangeCounter.strangeCounter(4));
        System.out.println("Expected: 6");
        System.out.println("--------------------");

        // Test Case 4: t = 9 (Second cycle, last second)
        // Cycle starts at t=4 with value 6. Duration is 6. Ends at 4+6-1 = 9.
        // At t=9, value should be 1.
        System.out.println("Test Case 4: t = 9");
        System.out.println("Input: 9");
        System.out.println("Output: " + StrangeCounter.strangeCounter(9));
        System.out.println("Expected: 1");
        System.out.println("--------------------");

        // Test Case 5: t = 10 (Third cycle, first second)
        // Expected: 12
        System.out.println("Test Case 5: t = 10");
        System.out.println("Input: 10");
        System.out.println("Output: " + StrangeCounter.strangeCounter(10));
        System.out.println("Expected: 12");
        System.out.println("--------------------");

    }
}
