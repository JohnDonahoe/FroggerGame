package com.example.m1.Screens;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.m1.Classes.*;
import com.example.m1.R;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class GameScreen extends AppCompatActivity {

    private Bitmap bitmap;

    private Canvas canvas;



    protected void onCreate(Bundle init) {
        super.onCreate(init);
        setContentView(R.layout.game_screen);
        initializeGame();
    }

    private void initializeGame() {

    }
}