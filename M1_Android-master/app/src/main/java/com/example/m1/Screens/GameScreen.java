package com.example.m1.Screens;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.m1.Classes.*;
import com.example.m1.R;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class GameScreen extends AppCompatActivity {

    private ScheduledExecutorService executorService;


    private boolean dead = false;


    private TextView lives;

    private TextView name;

    private TextView score;


    private TextView difficulty;


    private ImageView sprite;

    private Drawable spriteDraw;

    private int maxHeight = 10;

    private int[] location = {10, 4};

    protected Game game;

    private ImageView[][] imageDraws;

    private ImageView[] goalTiles;

    private static int scoreNum = 0;

    public static int getScoreNum() {
        return scoreNum;
    }


    protected void onCreate(Bundle init) {
        super.onCreate(init);
        setContentView(R.layout.game_screen);
        initializeGame();
    }

    private void initializeGame() {
        initImageDraws();
        game = ConfigScreen.getGame();
        lives = (TextView) findViewById(R.id.lives_display);
        name = (TextView) findViewById(R.id.name_display);
        score = (TextView) findViewById(R.id.points_display);
        score.setText(Integer.toString(game.getScore()));
        scoreNum = 0;
        difficulty = (TextView) findViewById(R.id.difficulty_display);
        //gameViewing = (ImageView) findViewById(R.id.gameImage);
        difficulty.setText(game.getDifficulty());
        name.setText(game.getName());
        lives.setText(Integer.toString(game.getLives()));

        f1 = getDrawable(R.drawable.f1car);
        pinkCar = getDrawable(R.drawable.pinkcar);
        bus1 = getDrawable(R.drawable.bus1);
        bus2 = getDrawable(R.drawable.bus2);

        goalTiles = new ImageView[]{findViewById(R.id.Goal1), findViewById(R.id.Goal2),
                findViewById(R.id.Goal3), findViewById(R.id.Goal4)};


        sprite = imageDraws[10][4];

        switch (game.getFrog().getColor()) {
        case ("Red"):
            spriteDraw = getDrawable(R.drawable.redfrogger);
            break;
        case ("Green"):
            spriteDraw = getDrawable(R.drawable.pngwing_com);
            break;
        default:
            spriteDraw = getDrawable(R.drawable.pngfind_com_frogger_png_5284221);
            break;
        }
        sprite.setImageDrawable(spriteDraw);


        roadUpdate();


        // need to add loop in here
        // call gameLoop()
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> gameLoop(), 0, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> gameLoop(), 0, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> gameLoop(), 0, 2, TimeUnit.SECONDS);
        //executorService.shutdownNow();

    }


    private static int timer = 0;
    public void gameLoop() {
        timer++;

        // update f1 cars
        if (timer % 2 == 0) {
            Car.updateF1Cars();
            if (checkDeath()) {
                die();
            }
        }

        if (timer % 5 == 0) {
            Car.updatePinkCars();
            if (checkDeath()) {
                die();
            }
        }

        if (timer % 7 == 0) {
            Car.updateTrucks();
            if (checkDeath()) {
                die();
            }
        }
        roadUpdate();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_UP:
            if (location[0] == 0) {
                return false;
            }
            sprite.setImageDrawable(null);
            location[0]--;
            sprite = imageDraws[location[0]][location[1]];
            sprite.setImageDrawable(spriteDraw);
            if (location[0] < maxHeight) {
                maxHeight = location[0];
                switch (maxHeight) {
                case 9:
                    scoreNum += 30;
                    break;
                case 8:
                    scoreNum += 10;
                    break;
                case 7:
                    scoreNum += 10;
                    break;
                case 6:
                    scoreNum += 30;
                    break;
                case 5:
                    scoreNum += 20;
                    break;
                case 4:
                    scoreNum += 10;
                    break;
                case 3:
                    scoreNum += 20;
                    break;
                case 2:
                    scoreNum += 40;
                    break;
                case 1:
                    scoreNum += 60;
                    break;
                case 0:
                    scoreNum += 70;
                    break;
                default:
                    break;
                }
                score.setText(Integer.toString(scoreNum));
            }
            if (checkDeath()) {
                die();
            }
            return true;
            // Draw frog at new position
        case KeyEvent.KEYCODE_DPAD_DOWN:
            if (location[0] == 10) {
                return false;
            }
            sprite.setImageDrawable(null);
            location[0]++;
            sprite = imageDraws[location[0]][location[1]];
            sprite.setImageDrawable(spriteDraw);
            if (checkDeath()) {
                die();
            }
            return true;
            // Draw frog at new position
        case KeyEvent.KEYCODE_DPAD_LEFT:
            if (location[1] == 0) {
                return false;
            }
            sprite.setImageDrawable(null);
            location[1]--;
            sprite = imageDraws[location[0]][location[1]];
            sprite.setImageDrawable(spriteDraw);
            if (checkDeath()) {
                die();
            }
            return true;
            // Draw frog at new position
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            if (location[1] == 7) {
                return false;
            }
            sprite.setImageDrawable(null);
            location[1]++;
            sprite = imageDraws[location[0]][location[1]];
            sprite.setImageDrawable(spriteDraw);
            if (checkDeath()) {
                die();
            }
            return true;
            // Draw frog at new position
        default:
            return false;
        }
    }

    public void initImageDraws() {
        imageDraws = new ImageView[][]{
                {findViewById(R.id.river03), findViewById(R.id.river13),
                        findViewById(R.id.river23), findViewById(R.id.river33),
                        findViewById(R.id.river43), findViewById(R.id.river53),
                        findViewById(R.id.river63), findViewById(R.id.river73)},
                {findViewById(R.id.river02), findViewById(R.id.river12),
                        findViewById(R.id.river22), findViewById(R.id.river32),
                        findViewById(R.id.river42), findViewById(R.id.river52),
                        findViewById(R.id.river62), findViewById(R.id.river72)},
                {findViewById(R.id.river01), findViewById(R.id.river11),
                        findViewById(R.id.river21), findViewById(R.id.river31),
                        findViewById(R.id.river41), findViewById(R.id.river51),
                        findViewById(R.id.river61), findViewById(R.id.river71)},
                {findViewById(R.id.river00), findViewById(R.id.river10),
                        findViewById(R.id.river20), findViewById(R.id.river30),
                        findViewById(R.id.river40), findViewById(R.id.river50),
                        findViewById(R.id.river60), findViewById(R.id.river70)},
                {findViewById(R.id.mid0), findViewById(R.id.mid1),
                        findViewById(R.id.mid2), findViewById(R.id.mid3),
                        findViewById(R.id.mid4), findViewById(R.id.mid5),
                        findViewById(R.id.mid6), findViewById(R.id.mid7)},
                {findViewById(R.id.road04), findViewById(R.id.road14),
                        findViewById(R.id.road24), findViewById(R.id.road34),
                        findViewById(R.id.road44), findViewById(R.id.road54),
                        findViewById(R.id.road64), findViewById(R.id.road74)},
                {findViewById(R.id.road03), findViewById(R.id.road13),
                        findViewById(R.id.road23), findViewById(R.id.road33),
                        findViewById(R.id.road43), findViewById(R.id.road53),
                        findViewById(R.id.road63), findViewById(R.id.road73)},
                {findViewById(R.id.road02), findViewById(R.id.road12),
                        findViewById(R.id.road22), findViewById(R.id.road32),
                        findViewById(R.id.road42), findViewById(R.id.road52),
                        findViewById(R.id.road62), findViewById(R.id.road72)},
                {findViewById(R.id.road01), findViewById(R.id.road11),
                        findViewById(R.id.road21), findViewById(R.id.road31),
                        findViewById(R.id.road41), findViewById(R.id.road51),
                        findViewById(R.id.road61), findViewById(R.id.road71)},
                {findViewById(R.id.road00), findViewById(R.id.road10),
                        findViewById(R.id.road20), findViewById(R.id.road30),
                        findViewById(R.id.road40), findViewById(R.id.road50),
                        findViewById(R.id.road60), findViewById(R.id.road70)},
                {findViewById(R.id.base0), findViewById(R.id.base1),
                        findViewById(R.id.base2), findViewById(R.id.base3),
                        findViewById(R.id.base4), findViewById(R.id.base5),
                        findViewById(R.id.base6), findViewById(R.id.base7)}
        };
    }

    private static Drawable f1;
    private static Drawable pinkCar;

    private static Drawable bus1;

    private static Drawable bus2;
    public void roadUpdate() {






        imageDraws[Car.getF1Car1()[0]]
                [Car.getF1Car1()[1] - 1 > -1 ? Car.getF1Car1()[1] - 1 : 7].setImageDrawable(null);
        imageDraws[Car.getF1Car1()[0]]
                [Car.getF1Car1()[1]].setImageDrawable(f1);

        imageDraws[Car.getF1Car2()[0]]
                [Car.getF1Car2()[1] - 1 > -1 ? Car.getF1Car2()[1] - 1 : 7].setImageDrawable(null);
        imageDraws[Car.getF1Car2()[0]]
                [Car.getF1Car2()[1]].setImageDrawable(f1);

        imageDraws[Car.getF1Car3()[0]]
                [Car.getF1Car3()[1] - 1 > -1 ? Car.getF1Car3()[1] - 1 : 7].setImageDrawable(null);
        imageDraws[Car.getF1Car3()[0]]
                [Car.getF1Car3()[1]].setImageDrawable(f1);

        imageDraws[Car.getF1Car4()[0]]
                [Car.getF1Car4()[1] - 1 > -1 ? Car.getF1Car4()[1] - 1 : 7].setImageDrawable(null);
        imageDraws[Car.getF1Car4()[0]]
                [Car.getF1Car4()[1]].setImageDrawable(f1);


        imageDraws[Car.getPinkCar1()[0]]
                [Car.getPinkCar1()[1] + 1 < 8 ? Car.getPinkCar1()[1] + 1 : 0]
                .setImageDrawable(null);
        imageDraws[Car.getPinkCar1()[0]]
                [Car.getPinkCar1()[1]].setImageDrawable(pinkCar);

        imageDraws[Car.getPinkCar2()[0]]
                [Car.getPinkCar2()[1] + 1 < 8 ? Car.getPinkCar2()[1] + 1 : 0]
                .setImageDrawable(null);
        imageDraws[Car.getPinkCar2()[0]]
                [Car.getPinkCar2()[1]].setImageDrawable(pinkCar);

        imageDraws[Car.getPinkCar3()[0]]
                [Car.getPinkCar3()[1] + 1 < 8 ? Car.getPinkCar3()[1] + 1 : 0]
                .setImageDrawable(null);
        imageDraws[Car.getPinkCar3()[0]]
                [Car.getPinkCar3()[1]].setImageDrawable(pinkCar);

        imageDraws[Car.getPinkCar4()[0]]
                [Car.getPinkCar4()[1] + 1 < 8 ? Car.getPinkCar4()[1] + 1 : 0]
                .setImageDrawable(null);
        imageDraws[Car.getPinkCar4()[0]]
                [Car.getPinkCar4()[1]].setImageDrawable(pinkCar);

        imageDraws[Car.getPinkCar5()[0]]
                [Car.getPinkCar5()[1] + 1 < 8 ? Car.getPinkCar5()[1] + 1 : 0]
                .setImageDrawable(null);
        imageDraws[Car.getPinkCar5()[0]]
                [Car.getPinkCar5()[1]].setImageDrawable(pinkCar);


        imageDraws[Car.getTruck1()[0][0]]
                [Car.getTruck1()[0][1]].setImageDrawable(bus1);
        imageDraws[Car.getTruck1()[1][0]]
                [Car.getTruck1()[1][1]].setImageDrawable(bus2);
        imageDraws[Car.getTruck1()[1][0]]
                [Car.getTruck1()[1][1] + 1 < 8 ? Car.getTruck1()[1][1] + 1 : 0]
                .setImageDrawable(null);

        imageDraws[Car.getTruck2()[0][0]]
                [Car.getTruck2()[0][1]].setImageDrawable(bus1);
        imageDraws[Car.getTruck2()[1][0]]
                [Car.getTruck2()[1][1]].setImageDrawable(bus2);
        imageDraws[Car.getTruck2()[1][0]]
                [Car.getTruck2()[1][1] + 1 < 8 ? Car.getTruck2()[1][1] + 1 : 0]
                .setImageDrawable(null);

        imageDraws[location[0]][location[1]].setImageDrawable(spriteDraw);
        // then set locations in Car.java to respective cars
    }

    public void die() {
        if (game.getLives() > 1) {
            resetFrog();
            resetScore();
            game.takeLife();
            lives.setText(Integer.toString(game.getLives()));
            roadUpdate();
        } else {
            executorService.shutdownNow();
            Intent intent = new Intent(getApplicationContext(), EndScreen.class);
            startActivity(intent);
            setContentView(R.layout.end_screen);
            finish();
        }
    }

    public void win() {
        executorService.shutdownNow();
        Intent intent = new Intent(getApplicationContext(), WinScreen.class);
        startActivity(intent);
        setContentView(R.layout.win_screen);
        finish();
    }



    private void resetFrog() {
        sprite.setImageDrawable(null);                      // Erases old sprite
        location[0] = 10;
        location[1] = 4;                                    // Resets location
        sprite = imageDraws[location[0]][location[1]];      // Draws new sprite
        sprite.setImageDrawable(spriteDraw);                // Shows sprite on screen
    }

    private void resetScore() {
        scoreNum = 0;
        maxHeight = 10;
        score.setText(Integer.toString(scoreNum));
    }

    public boolean checkDeath() {
        int row = location[0];
        if (row <= 9 && row >= 5) {
            return checkCollision(row);
        } else if (row >= 0 && row <= 3) {
            return checkWater(row);
        } else {
            return false;
        }
    }

    private boolean checkCollision(int row) {
        int col = location[1];
        switch (row) {
        case 5:
            if (col == Car.getTruck1()[0][1] || col == Car.getTruck1()[1][1]
                    || col == Car.getTruck2()[0][1]
                    || col == Car.getTruck2()[1][1]) {
                return true;
            }
            return false;
        case 6:
            if (col == Car.getF1Car3()[1] || col == Car.getF1Car4()[1]) {
                return true;
            }
            return false;
        case 7:
            if (col == Car.getPinkCar4()[1] || col == Car.getPinkCar5()[1]) {
                return true;
            }
            return false;
        case 8:
            if (col == Car.getPinkCar1()[1] || col == Car.getPinkCar2()[1]
                    || col == Car.getPinkCar3()[1]) {
                return true;
            }
            return false;
        case 9:
            if (col == Car.getF1Car1()[1] || col == Car.getF1Car2()[1]) {
                return true;
            }
            return false;
        default:
            return false;
        }
    }

    // Implementation will change once logs are added.
    private static boolean checkWater(int row) {
        return true;
    }
}