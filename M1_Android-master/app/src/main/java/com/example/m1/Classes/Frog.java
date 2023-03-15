package com.example.m1.Classes;

import android.graphics.Rect;
import android.view.KeyEvent;

public class Frog {
    private String color;
    private String imageName;
    private Rect rectangle;
    private int positionX;
    private int positionY;

    public Frog(String color, int left, int top, int right, int bottom) {
        this.color = color;
        if (color.equals("Blue")) {
            this.imageName = "pngfind_com_frogger_png_5284221.png";
        } else if (color.equals("Red")) {
            this.imageName = "pngwing_com.png";
        } else {
            this.imageName = "redfrogger.png";
        }
        this.rectangle = new Rect(left, top, right, bottom);
        this.positionX = 6;
        this.positionY = 12;
    }

    public String getColor() {
        return this.color;
    }

    public String getImageName() {
        return this.imageName;
    }

    public Rect getRectangle() {
        return this.rectangle;
    }

    public int[] getPosition() {
        int[] temp = {positionX, positionY};
        return temp;
    }

    public void setPosition(int[] position) {
        this.positionX = position[0];
        this.positionY = position[1];
    }

    public int[] moveLeft() {
        if (!(positionX == 0)) {
            positionX -= 1;
        }
        int[] temp = {positionX, positionY};
        return temp;
    }

    public int[] moveRight() {
        if (!(positionX == 13)) {
            positionX += 1;
        }
        int[] temp = {positionY, positionY};
        return temp;
    }

    public int[] moveUp() {
        if (!(positionY == 0)) {
            positionY -= 1;
        }
        int[] temp = {positionX, positionY};
        return temp;
    }

    public int[] moveDown() {
        if (!(positionY == 12)) {
            positionY += 1;
        }
        int[] temp = {positionX, positionY};
        return temp;
    }

    public int[] move(int event) {
        if (event == KeyEvent.KEYCODE_DPAD_UP) {
            return moveUp();
        } else if (event == KeyEvent.KEYCODE_DPAD_DOWN) {
            return moveDown();
        } else if (event == KeyEvent.KEYCODE_DPAD_RIGHT) {
            return moveRight();
        } else if (event == KeyEvent.KEYCODE_DPAD_LEFT) {
            return moveLeft();
        }
        return new int[]{positionX, positionY};
    }
}