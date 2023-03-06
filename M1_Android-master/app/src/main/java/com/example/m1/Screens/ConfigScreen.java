package com.example.m1.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.m1.R;
import android.widget.*;

public class ConfigScreen extends AppCompatActivity {
    protected Game game;
    private Button nameButton, start;
    private RadioButton easy, medium, hard, red, blue, green;
    private EditText enterNameBox;
    private textView error;
    protected void onCreate(Bundle int) {
        super.onCreate(init);
        setContentView(R.layout.config_screen);
        init();
    }

    private void init() {
        game = new Game();

        nameButton = (Button) findViewById(R.id.button3);
        enterNameBox = (EditText) findViewById(R.id.editTextTextPersonName);
        nameButton.setOnClickListener(this);

        easy = (RadioButton) findViewById(R.id.radioButton3);
        easy.setOnClickListener(this);
        medium = (RadioButton) findViewById(R.id.radioButton4);
        medium.setOnClickListener(this);
        hard = (RadioButton) findViewById(R.id.radioButton5);
        hard.setOnClickListener(this);

        red = (RadioButton) findViewById(R.id.radioButton12);
        red.setOnClickListener(this);
        blue = (RadioButton) findViewById(R.id.radioButton13);
        blue.setOnClickListener(this);
        green = (RadioButton) findViewById(R.id.radioButton14);
        green.setOnClickListener(this);

        Button start = (Button) findViewById(R.id.button2);
        start.setOnClickListener(this);


        error = (TextView) findViewById(R.id.textView7);
    }
}
