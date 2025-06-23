package com.manindra.leetcodeEasy;

public class GuessGame { //solution 374

    public static void main(String[] args) {
        GuessGame game = new GuessGame(6);
        System.out.println(game.guessNumber(10)); // Output: 6
    }

    private int pick; // the number to guess

    public GuessGame(int pick) {
        this.pick = pick;
    }

    // Simulates the guess API
    private int guess(int num) {
        if (num > pick) return -1;
        else if (num < pick) return 1;
        else return 0;
    }

    public int guessNumber(int n) {
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = guess(mid);
            if (result == 0) return mid;
            else if (result < 0) high = mid - 1;
            else low = mid + 1;
        }

        return -1; // should never reach here
    }

}

