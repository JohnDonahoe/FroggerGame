package com.example.m1.Screens;
import android.media.Image;
import android.os.Bundle;
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

    protected Game game = ConfigScreen.game;



    protected void onCreate(Bundle init) {
        super.onCreate(init);
        setContentView(R.layout.game_screen);
        initializeGame();
    }

    private void initializeGame() {
        lives = (TextView) findViewById(R.id.numLives);
        name = (TextView) findViewById(R.id.textView5);
        score = (TextView) findViewById(R.id.textView10);
        score.setText(Integer.toString(game.getScore()));
        difficulty = (TextView) findViewById(R.id.textView8);
        gameViewing = (ImageView) findViewById(R.id.gameImage);
        difficulty.setText(game.getDifficulty());
        name.setText(game.getName());
        lives.setText(Integer.toString(game.getLives()));
        builtBitmap();
    }

    private void builtBitmap() {
        bitmap = Bitmap.createBitmap(1080, 1080, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        gameViewing.setImageBitmap(bitmap);
    }
}