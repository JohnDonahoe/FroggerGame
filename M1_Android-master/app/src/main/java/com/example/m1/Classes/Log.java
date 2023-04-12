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
        row1Log1[0][1] = (row1Log1[0][1] - 1 == -1 ? 7 : row1Log1[0][1] - 1);
        row1Log1[1][1] = (row1Log1[1][1] - 1 == -1 ? 7 : row1Log1[1][1] - 1);

        row1Log2[0][1] = (row1Log2[0][1] - 1 == -1 ? 7 : row1Log2[0][1] - 1);
        row1Log2[1][1] = (row1Log2[1][1] - 1 == -1 ? 7 : row1Log2[1][1] - 1);

        row1Log3[0][1] = (row1Log3[0][1] - 1 == -1 ? 7 : row1Log3[0][1] - 1);
        row1Log3[1][1] = (row1Log3[1][1] - 1 == -1 ? 7 : row1Log3[1][1] - 1);
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
        row3Log1[0][1] = (row3Log1[0][1] - 1 == -1 ? 7 : row3Log1[0][1] - 1);
        row3Log1[1][1] = (row3Log1[1][1] - 1 == -1 ? 7 : row3Log1[1][1] - 1);
        row3Log1[2][1] = (row3Log1[2][1] - 1 == -1 ? 7 : row3Log1[2][1] - 1);

        row3Log2[0][1] = (row3Log2[0][1] - 1 == -1 ? 7 : row3Log2[0][1] - 1);
        row3Log2[1][1] = (row3Log2[1][1] - 1 == -1 ? 7 : row3Log2[1][1] - 1);
        row3Log2[2][1] = (row3Log2[2][1] - 1 == -1 ? 7 : row3Log2[2][1] - 1);
    }

    public static void updateRow4() {
        row4Log1[0][1] = (row4Log1[0][1] + 1) % 8;
        row4Log1[1][1] = (row4Log1[1][1] + 1) % 8;

        row4Log2[0][1] = (row4Log2[0][1] + 1) % 8;
        row4Log2[1][1] = (row4Log2[1][1] + 1) % 8;

        row4Log3[0][1] = (row4Log3[0][1] + 1) % 8;
        row4Log3[1][1] = (row4Log3[1][1] + 1) % 8;
    }

    public static int[][] getRow1Log1() {
        return row1Log1;
    }
    public static int[][] getRow1Log2() {
        return row1Log2;
    }
    public static int[][] getRow1Log3() {
        return row1Log3;
    }
    public static int[][] getRow2Log1() {
        return row2Log1;
    }
    public static int[][] getRow2Log2() {
        return row2Log2;
    }
    public static int[][] getRow3Log1() {
        return row3Log1;
    }
    public static int[][] getRow3Log2() {
        return row3Log2;
    }
    public static int[][] getRow4Log1() {
        return row4Log1;
    }
    public static int[][] getRow4Log2() {
        return row4Log2;
    }
    public static int[][] getRow4Log3() {
        return row4Log3;
    }

    public static int getRow1Speed() {
        return row1Speed;
    }
    public static int getRow2Speed() {
        return row2Speed;
    }
    public static int getRow3Speed() {
        return row3Speed;
    }
    public static int getRow4Speed() {
        return row4Speed;
    }

    public static boolean checkRow1(int col) {
        return (col == row1Log1[0][1] || col == row1Log1[1][1] || col == row1Log2[0][1] || col == row1Log2[1][1] || col == row1Log3[0][1] || col == row1Log3[1][1]);
    }

    public static boolean checkRow2(int col) {
        return (col == row2Log1[0][1] || col == row2Log1[1][1] || col == row2Log2[0][1] || col == row2Log2[1][1]);
    }

    public static boolean checkRow3(int col) {
        return (col == row3Log1[0][1] || col == row3Log1[1][1] || col == row3Log2[0][1] || col == row3Log2[1][1]);
    }

    public static boolean checkRow4(int col) {
        return (col == row4Log1[0][1] || col == row4Log1[1][1] || col == row4Log2[0][1] || col == row4Log2[1][1] || col == row4Log3[0][1] || col == row4Log3[1][1]);
    }
}
