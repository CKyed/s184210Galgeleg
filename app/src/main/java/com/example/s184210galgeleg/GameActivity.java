package com.example.s184210galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import logic.GameLogic;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    GameLogic logic = new GameLogic();
    private TextView gameText1, gameText2, gameText3;
    private Button playButton;
    private EditText etLetter;
    private String sLetter;
    private ImageView hangmanImage;
    private int failedAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        playButton = findViewById(R.id.playButton);
        etLetter = findViewById(R.id.letterValue);
        hangmanImage = findViewById(R.id.hangmanImage);
        gameText1 = findViewById(R.id.gameText1);
        gameText2 = findViewById(R.id.gameText2);
        gameText3 = findViewById(R.id.gameText3);
        hangmanImage.setImageResource(R.drawable.galge);
        playButton.setOnClickListener(this);


        logic.logStatus();
    }

    @Override
    public void onClick(View v) {
        if(v==playButton){
            sLetter = etLetter.getText().toString();
            if(sLetter.length()!=1){
                etLetter.getText().clear();
                etLetter.setError("Indtast kun 1 bogstav");
                sLetter=null;
                return;
            }
            logic.gætBogstav(sLetter);
            etLetter.getText().clear();
            System.out.println(sLetter);
            updateScreen();

        }
    }

    public void updateScreen(){
        int wrongLetters = logic.getAntalForkerteBogstaver();
        failedAttempts = logic.getAntalForkerteBogstaver();
        if (logic.erSpilletVundet()){
            Intent i = new Intent(this, GameFinish.class);
            i.putExtra("word", logic.getOrdet());
            i.putExtra("hasWon",true);
            i.putExtra("attempts", failedAttempts);
            startActivity(i);
        }

        gameText1.setText("Dit ord" + logic.getSynligtOrd());
        gameText2.setText("Du har gættet " + wrongLetters +" antal gange forkert.");
        gameText3.setText("Bogstaver du har gættet på: "+logic.getBrugteBogstaver());
        switch (wrongLetters){
            //Kunne godt have været lavet pænere og mindre redudant.
            case 1:
                hangmanImage.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                hangmanImage.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                hangmanImage.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                hangmanImage.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                hangmanImage.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                hangmanImage.setImageResource(R.drawable.forkert6);
                Intent i = new Intent(this, GameFinish.class);
                i.putExtra("word", logic.getOrdet());
                i.putExtra("hasWon",false);
                i.putExtra("attempts", failedAttempts);
                startActivity(i);
                break;
        }
    }
}