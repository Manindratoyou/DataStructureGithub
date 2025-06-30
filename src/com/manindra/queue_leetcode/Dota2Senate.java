package com.manindra.queue_leetcode;

import java.util.*;

public class Dota2Senate { //solution 649

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));    // Output: Radiant
        System.out.println(predictPartyVictory("RDD"));   // Output: Dire
        System.out.println(predictPartyVictory("DRRDR")); // Output: Radiant
    }

    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Fill initial positions
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // The one with smaller index bans the other
            if (rIndex < dIndex) {
                radiant.offer(rIndex + n); // go to next round
            } else {
                dire.offer(dIndex + n); // go to next round
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }


}

