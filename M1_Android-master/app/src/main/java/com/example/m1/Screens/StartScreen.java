package com.example.m1.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.m1.R;

public class StartScreen extends AppCompatActivity {
    
    protected void onCreate(Bundle save) {
        super.onCreate(save);

        setContentView(R.layout.start_screen);

        Button start = findViewById(R.id.startButton);
        start.setOnClickListener(v -> openConfigScreen());


        Button exit = findViewById(R.id.exitButton);
        exit.setOnClickListener(v -> finish());
    }

    public void openConfigScreen() {
        Intent intent = new Intent(getApplicationContext(), ConfigScreen.class);
        startActivity(intent);
        setContentView(R.layout.config_screen);
    }
    
}
