package com.example.m1.Classes;

public class Car {

    static int[] f1Car1 = {9, 0};

    static int[] f1Car2 = {9, 4};

    static int[] f1Car3 = {6, 1};

    static int[] f1Car4 = {6, 6};

    static int[] pinkCar1 = {8, 1};

    static int[] pinkCar2 = {8, 3};

    static int[] pinkCar3 = {8, 7};

    static int[] pinkCar4 = {7, 1};

    static int[] pinkCar5 = {7, 5};

    static int[][] truck1 = {{5, 0}, {5, 1}};

    static int[][] truck2 = {{5, 5}, {5, 6}};


    public static void updateTrucks() {
        truck1[0][1] = (truck1[0][1] - 1) % 8;
        truck1[1][1] = (truck1[1][1] - 1) % 8;

        truck2[0][1] = (truck2[0][1] - 1) % 8;
        truck2[1][1] = (truck2[1][1] - 1) % 8;
    }

    public static void updatePinkCars() {
        pinkCar1[1] = (pinkCar1[1] - 1) % 8;
        pinkCar2[1] = (pinkCar2[1] - 1) % 8;
        pinkCar3[1] = (pinkCar3[1] - 1) % 8;
        pinkCar4[1] = (pinkCar4[1] - 1) % 8;
        pinkCar5[1] = (pinkCar5[1] - 1) % 8;
    }

    public static void updateF1Cars() {
        f1Car1[1] = (f1Car1[1] - 1) % 8;
        f1Car2[1] = (f1Car2[1] - 1) % 8;
        f1Car3[1] = (f1Car3[1] - 1) % 8;
        f1Car4[1] = (f1Car4[1] - 1) % 8;
    }

}
