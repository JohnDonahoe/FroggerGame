package com.example.m1.Classes;

import android.graphics.drawable.Drawable;

public class Car {

    public static int[] f1Car1 = {9, 0};

    public static int[] f1Car2 = {9, 4};

    public static int[] f1Car3 = {6, 1};

    public static int[] f1Car4 = {6, 6};

    public static int[] pinkCar1 = {8, 1};

    public static int[] pinkCar2 = {8, 3};

    public static int[] pinkCar3 = {8, 7};

    public static int[] pinkCar4 = {7, 1};

    public static int[] pinkCar5 = {7, 5};

    public static int[][] truck1 = {{5, 0}, {5, 1}};

    public static int[][] truck2 = {{5, 5}, {5, 6}};

    public static int f1CarSpeed = 2;
    public static int pinkCarSpeed = 5;
    public static int truckSpeed = 7;


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

}
