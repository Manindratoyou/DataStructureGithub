package com.manindra.interview_2;

/*
you have a robot:
   you’ll get input as a string UUUDDDFLLRRDAYJD

U - means up
D - means down
L - means left
R - means right
ignore other input letters

write a program to find the final coordinates of the robot in a graph

for example

input - UUU
output- (0,3)
 */
public class RobotCoordinates {

    public static int[] getFinalCoordinates(String input) {
        int[] coordinates = {0, 0}; // Initial coordinates (x, y)

        if (input == null || input.isEmpty()) {
            return coordinates; // No movements, return initial coordinates
        }

        for (char direction : input.toCharArray()) {
            switch (direction) {
                case 'U':
                    coordinates[1]++; // Move up (increment y)
                    break;
                case 'D':
                    coordinates[1]--; // Move down (decrement y)
                    break;
                case 'L':
                    coordinates[0]--; // Move left (decrement x)
                    break;
                case 'R':
                    coordinates[0]++; // Move right (increment x)
                    break;
                // Ignore other input letters
            }
        }

        return coordinates;
    }

    public static void main(String[] args) {
        // Example Usage
        String input = "UUU";
        int[] finalCoordinates = getFinalCoordinates(input);

        System.out.println("Final Coordinates: (" + finalCoordinates[0] + ", " + finalCoordinates[1] + ")");
    }
}

