package com.manindra.leetcodeEasy;

public class ParkingSystem { //solution 1603

    public static void main(String[] args) {

        // Creating a parking system with 3 big, 4 medium, and 5 small slots
        ParkingSystem parkingSystem = new ParkingSystem(3, 4, 5);

        // Adding cars to the parking system
        System.out.println("Adding a big car: " + parkingSystem.addCar(1)); // Should return true
        System.out.println("Adding a medium car: " + parkingSystem.addCar(2)); // Should return true
        System.out.println("Adding a small car: " + parkingSystem.addCar(3)); // Should return true

        // Adding more cars than available slots
        System.out.println("Adding a big car: " + parkingSystem.addCar(1)); // Should return false
        System.out.println("Adding a medium car: " + parkingSystem.addCar(2)); // Should return false
        System.out.println("Adding a small car: " + parkingSystem.addCar(3)); // Should return false

        // Adding an invalid car type
        System.out.println("Adding an invalid car type: " + parkingSystem.addCar(4)); // Should return false
    }

    private int big;
    private int medium;
    private int small;

    //constructor to initialize the number of slots for each type of car
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    //method to add a car of a specific type
    public boolean addCar(int carType) {
        switch (carType) {
            case 1: //Big Car
                if (big > 0) {
                    big--;
                    return true;
                }
                return false;
            case 2:  //Medium car
                if (medium > 0) {
                    medium--;
                    return true;
                }
                return false;
            case 3: //small car
                if (small > 0) {
                    small--;
                    return true;
                }
                return false;
            default:
                return false;//Invalid Car Type
        }
    }
}
