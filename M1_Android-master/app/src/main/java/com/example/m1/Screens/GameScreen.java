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

public class GameScreen extends AppCompatActivity {

    private Bitmap bitmap;

    private Canvas canvas;

    private TextView lives;

    private TextView name;

    private TextView score;


    private TextView difficulty;

    private ImageView gameViewing;

    private ImageView sprite;

    protected Game game;



    protected void onCreate(Bundle init) {
        super.onCreate(init);
        setContentView(R.layout.game_screen);
        initializeGame();
    }

    private void initializeGame() {
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

        sprite = findViewById(R.id.player_sprite);
        Drawable spriteDraw;
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
        


        //GameHandler game_handler = new GameHandler(this.game);

        //View map = findViewById(R.id.map);
        //game_handler.draw_map(map);
    }

    //private void builtBitmap() {
        //bitmap = Bitmap.createBitmap(1080, 1080, Bitmap.Config.ARGB_8888);
        //canvas = new Canvas(bitmap);
       // gameViewing.setImageBitmap(bitmap);
   // }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event) {
        switch (KeyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                game.getFrog().moveUp();
                return true;
                // Draw frog at new position
            case KeyEvent.KEYCODE_DPAD_DOWN:
                game.getFrog().moveDown();
                return true;
                // Draw frog at new position
            case KeyEvent.KEYCODE_DPAD_LEFT:
                game.getFrog().moveLeft();
                return true;
                // Draw frog at new position
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                game.getFrog().moveRight();
                return true;
                // Draw frog at new position
        }
        return false;
    }
}