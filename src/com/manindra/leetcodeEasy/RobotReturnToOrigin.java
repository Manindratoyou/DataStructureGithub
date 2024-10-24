package com.manindra.leetcodeEasy;

public class RobotReturnToOrigin { //solution 657

    public static void main(String[] args) {
        RobotReturnToOrigin robot = new RobotReturnToOrigin();
        String moves = "UDLR";
        System.out.println(robot.judgeCircle(moves));  // Output: true
    }
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;  // Move up
            } else if (move == 'D') {
                y--;  // Move down
            } else if (move == 'L') {
                x--;  // Move left
            } else if (move == 'R') {
                x++;  // Move right
            }
        }

        // If both x and y are 0, the robot returned to the origin
        return x == 0 && y == 0;
    }

}

