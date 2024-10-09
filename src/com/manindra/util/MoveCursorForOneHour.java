package com.manindra.util;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MoveCursorForOneHour {

    public static void main(String[] args) {
        try {
            // Run the mouse movement for one hour
            moveCursorForOneHour();
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void moveCursorForOneHour() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        int durationInMinutes = 60;
        int moveIntervalInMilliseconds = 30000;

        long endTime = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(durationInMinutes);

        while (System.currentTimeMillis() < endTime) {
            moveCursorRandomly(robot);
            Thread.sleep(moveIntervalInMilliseconds);
        }
    }

    private static void moveCursorRandomly(Robot robot) {
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        int x = (int) (Math.random() * screenWidth);
        int y = (int) (Math.random() * screenHeight);

        robot.mouseMove(x, y);

        System.out.println("Moved cursor to: (" + x + ", " + y + ")");
    }
}

