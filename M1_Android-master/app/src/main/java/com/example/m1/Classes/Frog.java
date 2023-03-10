package com.example.m1.Classes;

import android.graphics.Rect;

public class Frog {
    private String color;
    private String image_name;
    private Rect rectangle;
    private int position_x;
    private int position_y;

    public Frog(String color, int left, int top, int right, int bottom) {
        this.color = color;
        if (color.equals("Blue")) {
            this.image_name = "pngfind_com_frogger_png_5284221.png";
        } else if (color.equals("Red")) {
            this.image_name = "pngwing_com.png";
        } else {
            this.image_name = "redfrogger.png";
        }
        this.rectangle = new Rect(left, top, right, bottom);
        this.position_x = 6;
        this.position_y = 12;
    }

    public String getColor() {
        return this.color;
    }

    public String getImageName() {
        return this.image_name;
    }

    public Rect getRectangle() {
        return this.rectangle;
    }

    public int[] getPosition() {
        return new int[this.position_x, this.position_y];
    }

    public void setPosition(int[] position) {
        this.position_x = position[0];
        this.position_y = position[1];
    }

    public int[] moveLeft() {
        if (!(position_x == 0)) {
            position_x -= 1;
        }
        return new int[position_x, position_y];
    }

    public int[] moveRight() {
        if (!(position_x == 13)) {
            position_x += 1;
        }
        return new int[position_x, position_y];
    }

    public int[] moveUp() {
        if (!(position_y == 0)) {
            position_y -= 1;
        }
        return new int[position_x, position_y];
    }

    public int[] moveDown() {
        if (!(position_y == 12)) {
            position_y += 1;
        }
        return new int[position_x, position_y];
    }
}