package com.example.m1.Classes;

public class Car {

    private static int[] f1Car1 = {9, 0};

    private static int[] f1Car2 = {9, 4};

    private static int[] f1Car3 = {6, 1};

    private static int[] f1Car4 = {6, 6};

    private static int[] pinkCar1 = {8, 1};

    private static int[] pinkCar2 = {8, 3};

    private static int[] pinkCar3 = {8, 7};

    private static int[] pinkCar4 = {7, 1};

    private static int[] pinkCar5 = {7, 5};

    private static int[][] truck1 = {{5, 0}, {5, 1}};

    private static int[][] truck2 = {{5, 5}, {5, 6}};

    private static int f1CarSpeed = 2;
    private static int pinkCarSpeed = 5;
    private static int truckSpeed = 7;

    public static int[] getF1Car1() {
        return f1Car1;
    }

    public static int[] getF1Car2() {
        return f1Car2;
    }

    public static int[] getF1Car3() {
        return f1Car3;
    }

    public static int[] getF1Car4() {
        return f1Car4;
    }

    public static int[] getPinkCar1() {
        return pinkCar1;
    }

    public static int[] getPinkCar2() {
        return pinkCar2;
    }

    public static int[] getPinkCar3() {
        return pinkCar3;
    }

    public static int[] getPinkCar4() {
        return pinkCar4;
    }

    public static int[] getPinkCar5() {
        return pinkCar5;
    }

    public static int[][] getTruck1() {
        return truck1;
    }

    public static int[][] getTruck2() {
        return truck2;
    }

    public int getF1CarSpeed() {
        return f1CarSpeed;
    }

    public int getPinkCarSpeed() {
        return pinkCarSpeed;
    }

    public int getTruckSpeed() {
        return truckSpeed;
    }
    public static void updateTrucks() {
        truck1[0][1] = (truck1[0][1] - 1) % 8;
        truck1[1][1] = (truck1[1][1] - 1) % 8;

        truck2[0][1] = (truck2[0][1] - 1) % 8;
        truck2[1][1] = (truck2[1][1] - 1) % 8;

        if (truck1[0][1] == -1) {
            truck1[0][1] = 7;
        }
        if (truck2[0][1] == -1) {
            truck2[0][1] = 7;
        }

        if (truck1[1][1] == -1) {
            truck1[1][1] = 7;
        }
        if (truck2[1][1] == -1) {
            truck2[1][1] = 7;
        }
    }

    public static void updatePinkCars() {
        pinkCar1[1] = (pinkCar1[1] - 1) % 8;
        pinkCar2[1] = (pinkCar2[1] - 1) % 8;
        pinkCar3[1] = (pinkCar3[1] - 1) % 8;
        pinkCar4[1] = (pinkCar4[1] - 1) % 8;
        pinkCar5[1] = (pinkCar5[1] - 1) % 8;

        if (pinkCar1[1] == -1) {
            pinkCar1[1] = 7;
        }
        if (pinkCar2[1] == -1) {
            pinkCar2[1] = 7;
        }
        if (pinkCar3[1] == -1) {
            pinkCar3[1] = 7;
        }
        if (pinkCar4[1] == -1) {
            pinkCar4[1] = 7;
        }
        if (pinkCar5[1] == -1) {
            pinkCar5[1] = 7;
        }
    }

    public static void updateF1Cars() {
        f1Car1[1] = (f1Car1[1] + 1) % 8;
        f1Car2[1] = (f1Car2[1] + 1) % 8;
        f1Car3[1] = (f1Car3[1] + 1) % 8;
        f1Car4[1] = (f1Car4[1] + 1) % 8;
    }

    public static boolean checkCollision(int row, int col) {
        switch (row) {
        case 5:
            if (checkRow5(col)) {
                return true;
            }
            return false;
        case 6:
            if (checkRow6(col)) {
                return true;
            }
            return false;
        case 7:
            if (checkRow7(col)) {
                return true;
            }
            return false;
        case 8:
            if (checkRow8(col)) {
                return true;
            }
            return false;
        case 9:
            if (checkRow9(col)) {
                return true;
            }
            return false;
        default:
            return false;
        }
    }

    private static boolean checkRow5(int col) {
        return (col == truck1[0][1] || col == truck1[1][1] || col == truck2[0][1]
                || col == truck2[1][1]);
    }

    private static boolean checkRow6(int col) {
        return (col == f1Car3[1] || col == f1Car4[1]);
    }

    private static boolean checkRow7(int col) {
        return (col == pinkCar4[1] || col == pinkCar5[1]);
    }

    private static boolean checkRow8(int col) {
        return (col == pinkCar1[1] || col == pinkCar2[1]
                || col == pinkCar3[1]);
    }

    private static boolean checkRow9(int col) {
        return (col == f1Car1[1] || col == f1Car2[1]);
    }
}