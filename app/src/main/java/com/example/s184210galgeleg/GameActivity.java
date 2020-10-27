package com.example.s184210galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import logic.GameLogic;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    GameLogic logic = new GameLogic();
    private Button playButton;
    private EditText etLetter;
    private String sLetter;
    private ImageView hangmanImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        playButton = findViewById(R.id.playButton);
        playButton.setText("Spil");
        etLetter = findViewById(R.id.letterValue);
        hangmanImage = findViewById(R.id.hangmanImage);
        hangmanImage.setImageResource(R.drawable.galge);
        playButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==playButton){
            sLetter = etLetter.getText().toString();
            System.out.println(sLetter);
        }
    }
}