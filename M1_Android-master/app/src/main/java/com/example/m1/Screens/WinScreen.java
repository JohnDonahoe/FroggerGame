package com.example.m1.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.m1.R;

public class WinScreen extends AppCompatActivity {


    protected void onCreate(Bundle init) {
        super.onCreate(init);
        setContentView(R.layout.win_screen);
        Button b = findViewById(R.id.button5);

        b.setOnClickListener(e -> restartGame());

        Button exit = findViewById(R.id.button6);

        exit.setOnClickListener(V -> death());

        TextView score = findViewById(R.id.textView12);

        score.setText(Integer.toString(GameScreen.getScoreNum()));
    }

    public void restartGame() {
        Intent intent = new Intent(getApplicationContext(), ConfigScreen.class);
        startActivity(intent);
        setContentView(R.layout.config_screen);
    }

    public void death() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }




}
