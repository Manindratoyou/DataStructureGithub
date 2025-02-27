package com.manindra.iitp.labAI;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import java.util.*;

class WaterJugProblem {
    static class State {
        int jug12, jug8, jug3;

        State(int jug12, int jug8, int jug3) {
            this.jug12 = jug12;
            this.jug8 = jug8;
            this.jug3 = jug3;
        }

        @Override
        public String toString() {
            return "(" + jug12 + ", " + jug8 + ", " + jug3 + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            State state = (State) obj;
            return jug12 == state.jug12 && jug8 == state.jug8 && jug3 == state.jug3;
        }

        @Override
        public int hashCode() {
            return Objects.hash(jug12, jug8, jug3);
        }
    }

    public static void solveWaterJug() {
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State start = new State(0, 0, 0);
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            State current = queue.poll();
            System.out.println("Exploring state: " + current);

            if (current.jug12 == 1 || current.jug8 == 1 || current.jug3 == 1) {
                System.out.println("Solution Found: " + current);
                return;
            }

            // Generate new states by filling, emptying, and transferring water
            List<State> nextStates = generateNextStates(current);

            for (State nextState : nextStates) {
                if (!visited.contains(nextState)) {
                    queue.add(nextState);
                    visited.add(nextState);
                }
            }
        }

        System.out.println("No solution found.");
    }

    private static List<State> generateNextStates(State current) {
        List<State> nextStates = new ArrayList<>();

        // Fill each jug completely
        nextStates.add(new State(12, current.jug8, current.jug3));
        nextStates.add(new State(current.jug12, 8, current.jug3));
        nextStates.add(new State(current.jug12, current.jug8, 3));

        // Empty each jug
        nextStates.add(new State(0, current.jug8, current.jug3));
        nextStates.add(new State(current.jug12, 0, current.jug3));
        nextStates.add(new State(current.jug12, current.jug8, 0));

        // Transfer between jugs
        nextStates.add(transferWater(current, "12->8"));
        nextStates.add(transferWater(current, "12->3"));
        nextStates.add(transferWater(current, "8->12"));
        nextStates.add(transferWater(current, "8->3"));
        nextStates.add(transferWater(current, "3->12"));
        nextStates.add(transferWater(current, "3->8"));

        return nextStates;
    }

    private static State transferWater(State current, String action) {
        int jug12 = current.jug12, jug8 = current.jug8, jug3 = current.jug3;

        switch (action) {
            case "12->8":
                int pour12to8 = Math.min(jug12, 8 - jug8);
                return new State(jug12 - pour12to8, jug8 + pour12to8, jug3);
            case "12->3":
                int pour12to3 = Math.min(jug12, 3 - jug3);
                return new State(jug12 - pour12to3, jug8, jug3 + pour12to3);
            case "8->12":
                int pour8to12 = Math.min(jug8, 12 - jug12);
                return new State(jug12 + pour8to12, jug8 - pour8to12, jug3);
            case "8->3":
                int pour8to3 = Math.min(jug8, 3 - jug3);
                return new State(jug12, jug8 - pour8to3, jug3 + pour8to3);
            case "3->12":
                int pour3to12 = Math.min(jug3, 12 - jug12);
                return new State(jug12 + pour3to12, jug8, jug3 - pour3to12);
            case "3->8":
                int pour3to8 = Math.min(jug3, 8 - jug8);
                return new State(jug12, jug8 + pour3to8, jug3 - pour3to8);
            default:
                return current;
        }
    }

    public static void main(String[] args) {
        System.out.println("Solving Water Jug Problem:");
        solveWaterJug();
    }
}
