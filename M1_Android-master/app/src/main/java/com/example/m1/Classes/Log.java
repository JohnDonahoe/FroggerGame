package com.example.m1.Classes;

public class Log {

    private static int[][] row1Log1 = {{3, 0}, {3, 1}}; // left

    private static int[][] row1Log2 = {{3, 3}, {3, 4}}; // left

    private static int[][] row1Log3 = {{3, 6}, {3, 7}}; // left

    private static int[][] row2Log1 = {{2, 0}, {2, 1}, {2, 2}}; // right

    private static int[][] row2Log2 = {{2, 4}, {2, 5}, {2, 6}}; // right

    private static int[][] row3Log1 = {{1, 0}, {1, 1}, {1, 2}}; // left

    private static int[][] row3Log2 = {{1, 4}, {1, 5}, {1, 6}}; // left

    private static int[][] row4Log1 = {{0, 0}, {0, 1}}; // right

    private static int[][] row4Log2 = {{0, 3}, {0, 4}}; // right

    private static int[][] row4Log3 = {{0, 6}, {0, 7}}; // right

    private static int row1Speed = 3;

    private static int row2Speed = 4;

    private static int row3Speed = 2;

    private static int row4Speed = 5;


    public static void updateRow1() {
        row1Log1[0][1] = (row1Log1[0][1] - 1) % 8;
        row1Log1[1][1] = (row1Log1[1][1] - 1) % 8;

        row1Log2[0][1] = (row1Log2[0][1] - 1) % 8;
        row1Log2[1][1] = (row1Log2[1][1] - 1) % 8;

        row1Log3[0][1] = (row1Log3[0][1] - 1) % 8;
        row1Log3[1][1] = (row1Log3[1][1] - 1) % 8;
    }

    public static void updateRow2() {
        row2Log1[0][1] = (row2Log1[0][1] + 1) % 8;
        row2Log1[1][1] = (row2Log1[1][1] + 1) % 8;
        row2Log1[2][1] = (row2Log1[2][1] + 1) % 8;

        row2Log2[0][1] = (row2Log2[0][1] + 1) % 8;
        row2Log2[1][1] = (row2Log2[1][1] + 1) % 8;
        row2Log2[2][1] = (row2Log2[2][1] + 1) % 8;
    }

    public static void updateRow3() {
        row3Log1[0][1] = (row3Log1[0][1] - 1) % 8;
        row3Log1[1][1] = (row3Log1[1][1] - 1) % 8;
        row3Log1[2][1] = (row3Log1[2][1] - 1) % 8;

        row3Log2[0][1] = (row3Log2[0][1] - 1) % 8;
        row3Log2[1][1] = (row3Log2[1][1] - 1) % 8;
        row3Log2[2][1] = (row3Log2[2][1] - 1) % 8;
    }

    public static void updateRow4() {
        row4Log1[0][1] = (row4Log1[0][1] + 1) % 8;
        row4Log1[1][1] = (row4Log1[1][1] + 1) % 8;

        row4Log2[0][1] = (row4Log2[0][1] + 1) % 8;
        row4Log2[1][1] = (row4Log2[1][1] + 1) % 8;

        row4Log3[0][1] = (row4Log3[0][1] + 1) % 8;
        row4Log3[1][1] = (row4Log3[1][1] + 1) % 8;
    }
}
