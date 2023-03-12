package com.example.m1.Screens;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.m1.Classes.*;
import com.example.m1.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.util.concurrent.TimeUnit;

public class GameScreen extends AppCompatActivity {

    private Bitmap bitmap;

    private Canvas canvas;

    private TextView lives;

    private TextView name;

    private TextView score;


    private TextView difficulty;

    private ImageView gameViewing;

    private ImageView sprite;

    Drawable spriteDraw;

    private int maxHeight = 10;

    private int[] location = {10, 4};

    protected Game game;

    protected ImageView[][] imageDraws;

    private int scoreNum = 0;


    protected void onCreate(Bundle init) {
        super.onCreate(init);
        setContentView(R.layout.game_screen);
        initializeGame();
    }

    private void initializeGame() {
        initImageDraws();
        game = ConfigScreen.get_game();
        lives = (TextView) findViewById(R.id.lives_display);
        name = (TextView) findViewById(R.id.name_display);
        score = (TextView) findViewById(R.id.points_display);
        score.setText(Integer.toString(game.getScore()));
        difficulty = (TextView) findViewById(R.id.difficulty_display);
        //gameViewing = (ImageView) findViewById(R.id.gameImage);
        difficulty.setText(game.getDifficulty());
        name.setText(game.getName());
        lives.setText(Integer.toString(game.getLives()));

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
        

        gameLoop();
        //GameHandler game_handler = new GameHandler(this.game);

        //View map = findViewById(R.id.map);
        //game_handler.draw_map(map);
    }

    public void gameLoop() throws InterruptedException {
        int timer = 0;
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                timer++;


                // update f1 cars



                if (timer % 2 == 0) {
                    //update pink cars
                }



                if (timer % 3 == 0) {
                    //update trucks
                }


            } catch (Exception e) {
                continue;
            }

        }
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event) {
        switch (KeyCode) {
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
                        case 6:
                            scoreNum += 10;
                            break;
                        case 8:
                            scoreNum += 20;
                            break;
                        case 7:
                            scoreNum += 30;
                            break;
                        case 5:
                            scoreNum += 40;
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
                    }
                    score.setText(Integer.toString(scoreNum));
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
                return true;
                // Draw frog at new position
        }
        return false;
    }

    public void initImageDraws() {
        imageDraws = new ImageView[][]{
                {findViewById(R.id.river03), findViewById(R.id.river13), findViewById(R.id.river23), findViewById(R.id.river33), findViewById(R.id.river43), findViewById(R.id.river53), findViewById(R.id.river63), findViewById(R.id.river73)},
                {findViewById(R.id.river02), findViewById(R.id.river12), findViewById(R.id.river22), findViewById(R.id.river32), findViewById(R.id.river42), findViewById(R.id.river52), findViewById(R.id.river62), findViewById(R.id.river72)},
                {findViewById(R.id.river01), findViewById(R.id.river11), findViewById(R.id.river21), findViewById(R.id.river31), findViewById(R.id.river41), findViewById(R.id.river51), findViewById(R.id.river61), findViewById(R.id.river71)},
                {findViewById(R.id.river00), findViewById(R.id.river10), findViewById(R.id.river20), findViewById(R.id.river30), findViewById(R.id.river40), findViewById(R.id.river50), findViewById(R.id.river60), findViewById(R.id.river70)},
                {findViewById(R.id.mid0), findViewById(R.id.mid1), findViewById(R.id.mid2), findViewById(R.id.mid3), findViewById(R.id.mid4), findViewById(R.id.mid5), findViewById(R.id.mid6), findViewById(R.id.mid7)},
                {findViewById(R.id.road04), findViewById(R.id.road14), findViewById(R.id.road24), findViewById(R.id.road34), findViewById(R.id.road44), findViewById(R.id.road54), findViewById(R.id.road64), findViewById(R.id.road74)},
                {findViewById(R.id.road03), findViewById(R.id.road13), findViewById(R.id.road23), findViewById(R.id.road33), findViewById(R.id.road43), findViewById(R.id.road53), findViewById(R.id.road63), findViewById(R.id.road73)},
                {findViewById(R.id.road02), findViewById(R.id.road12), findViewById(R.id.road22), findViewById(R.id.road32), findViewById(R.id.road42), findViewById(R.id.road52), findViewById(R.id.road62), findViewById(R.id.road72)},
                {findViewById(R.id.road01), findViewById(R.id.road11), findViewById(R.id.road21), findViewById(R.id.road31), findViewById(R.id.road41), findViewById(R.id.road51), findViewById(R.id.road61), findViewById(R.id.road71)},
                {findViewById(R.id.road00), findViewById(R.id.road10), findViewById(R.id.road20), findViewById(R.id.road30), findViewById(R.id.road40), findViewById(R.id.road50), findViewById(R.id.road60), findViewById(R.id.road70)},
                {findViewById(R.id.base0), findViewById(R.id.base1), findViewById(R.id.base2), findViewById(R.id.base3), findViewById(R.id.base4), findViewById(R.id.base5), findViewById(R.id.base6), findViewById(R.id.base7)}
        };
    }
}