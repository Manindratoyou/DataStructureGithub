package com.manindra.iitp.labAI;

import java.util.*;

class MonkeyBananaProblem {
    static class State {
        boolean hasBanana;
        boolean isOnCrates;
        int crateCount;

        State(boolean hasBanana, boolean isOnCrates, int crateCount) {
            this.hasBanana = hasBanana;
            this.isOnCrates = isOnCrates;
            this.crateCount = crateCount;
        }
    }

    public static void solveMonkeyBanana() {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(false, false, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.hasBanana) {
                System.out.println("Monkey got the banana!");
                return;
            }
            if (state.crateCount < 2) {
                queue.add(new State(false, false, state.crateCount + 1));
            }
            if (state.crateCount == 2 && !state.isOnCrates) {
                queue.add(new State(false, true, 2));
            }
            if (state.isOnCrates) {
                queue.add(new State(true, true, 2));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Solving Monkey and Bananas Problem:");
        solveMonkeyBanana();
    }
}

