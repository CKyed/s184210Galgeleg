package com.example.s184210galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button gameButton, highscoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameButton = findViewById(R.id.gameButton);
        gameButton.setText("Start Spil");

        highscoreButton =  findViewById(R.id.highscoreButton);
        highscoreButton.setText("High score");

        gameButton.setOnClickListener(this);
        highscoreButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==gameButton){
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);
        }
        if(v==highscoreButton){
            Intent i = new Intent(this, HighscoreActivity.class);
            startActivity(i);

        }

    }
}