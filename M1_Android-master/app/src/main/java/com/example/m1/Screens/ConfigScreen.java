package com.example.m1.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.m1.Classes.*;
import com.example.m1.R;
import android.widget.*;

public class ConfigScreen extends AppCompatActivity implements View.OnClickListener {
    protected static Game game;
    private Button nameButton;
    private Button start;
    private RadioButton easy;
    private RadioButton medium;
    private RadioButton hard;
    private RadioButton red;
    private RadioButton blue;
    private RadioButton green;
    private EditText enterNameBox;
    private TextView error;

    private boolean nameSet;
    private boolean difficultySet;
    private boolean frogSet;
    protected void onCreate(Bundle init) {
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

        nameSet = false;
        difficultySet = false;
        frogSet = false;
    }

    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.button3:              //Name Button
            nameSet = game.setName(enterNameBox.getText().toString());
            if (!nameSet) {
                error.setText("Please set a name");
            }
            break;
        case R.id.radioButton3:         //Easy Button
            difficultySet = game.setDifficulty("Easy");
            break;
        case R.id.radioButton4:         //Medium Button
            difficultySet = game.setDifficulty("Medium");
            break;
        case R.id.radioButton5:         //Hard Button
            difficultySet = game.setDifficulty("Hard");
            break;
        case R.id.radioButton12:        //Red Frog Button
            game.setFrog(new Frog("Red", 0, 0, 0, 0));
            frogSet = true;
            break;
        case R.id.radioButton13:        //Blue Frog Button
            game.setFrog(new Frog("Blue", 0, 0, 0, 0));
            frogSet = true;
            break;
        case R.id.radioButton14:        //Green Frog Button
            game.setFrog(new Frog("Green", 0, 0, 0, 0));
            frogSet = true;
            break;
        case R.id.button2:         //Start Button
            if (nameSet && frogSet && difficultySet) {
                openGameScreen();
            }
            break;
        default:
            break;
        }
    }

    public void openGameScreen() {
        Intent intent = new Intent(getApplicationContext(), GameScreen.class);
        startActivity(intent);
        setContentView(R.layout.game_screen);
    }

    public static Game getGame() {
        return game;
    }
}
