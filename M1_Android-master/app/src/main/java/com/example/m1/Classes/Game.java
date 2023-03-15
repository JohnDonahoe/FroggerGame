package com.example.m1.Classes;

import android.view.KeyEvent;

public class Game {
    private String name;
    private String difficulty;
    private int lives;
    private Frog frog;
    private int score;

    public Game(String name, String difficulty, int lives, Frog frog) {
        this.name = name;
        this.difficulty = difficulty;
        this.lives = lives;
        this.frog = frog;
        this.score = 0;
    }

    public Game() {
        this(null, null, 0, null);
    }

    // Returns: name as string
    public String getName() {
        return this.name;
    }

    //Returns: difficulty as string
    public String getDifficulty() {
        return this.difficulty;
    }

    //Returns: lives as int
    public int getLives() {
        return this.lives;
    }

    //Returns: frog as Frog
    public Frog getFrog() {
        return this.frog;
    }

    //Returns: score as int
    public int getScore() {
        return this.score;
    }

    //  Sets the user's name
    //  Parameters: String name (to be set to)
    //  Returns:    true if the name is null or length is 0
    //              false if the name is valid
    public boolean setName(String name) {
        if (name == null || name.trim().length() == 0) {
            return false;
        }
        this.name = name;
        return true;
    }

    //  Sets the game's difficulty
    //  Parameters: String difficulty (to be set to)
    //  Returns:    true if name was set
    //              false if difficulty was not set
    public boolean setDifficulty(String difficulty) {
        if (difficulty.equals("Easy")) {
            this.difficulty = "Easy";
            this.lives = 3;
        } else if (difficulty.equals("Medium")) {
            this.difficulty = "Medium";
            this.lives = 2;
        } else if (difficulty.equals("Hard")) {
            this.difficulty = "Hard";
            this.lives = 1;
        } else {
            return false;
        }
        return true;
    }

    //  Set's the game's frog
    //  Parameters: Frog frog (to be set to)
    public void setFrog(Frog frog) {
        this.frog = frog;
    }

    public int score(int event, int locationY, int maxHeight) {
        if (event == KeyEvent.KEYCODE_DPAD_UP && locationY < maxHeight) {
            maxHeight = locationY;
            switch (maxHeight) {
                case 9:
                    score += 30;
                    break;
                case 8:
                    score += 10;
                    break;
                case 7:
                    score += 10;
                    break;
                case 6:
                    score += 30;
                    break;
                case 5:
                    score += 20;
                    break;
                case 4:
                    score += 10;
                    break;
                case 3:
                    score += 20;
                    break;
                case 2:
                    score += 40;
                    break;
                case 1:
                    score += 60;
                    break;
                case 0:
                    score += 70;
                    break;
            }
        }
        return maxHeight;
    }
}