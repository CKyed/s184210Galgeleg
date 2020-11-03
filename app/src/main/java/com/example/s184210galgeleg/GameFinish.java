package com.example.s184210galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class  GameFinish extends AppCompatActivity {
    private ImageView finishImage;
    private TextView finishText;
    private Button finishButton;
    private String word;
    private boolean hasWon;
    private SharedPreferences preferences;
    private int score;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_finish);
        finishImage = findViewById(R.id.gameFinishImage);
        finishText = findViewById(R.id.finishText);

        bundle = getIntent().getExtras();
        hasWon = bundle.getBoolean("hasWon");
        word = bundle.getString("word");
        score = bundle.getInt("attempts");
        System.out.println(hasWon);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);


        if(hasWon){
            finishText.setText("Tillykke. Du har vundet med " + score + " forkert forsøg");
            //TODO  Vælge det rigtige billede
            finishImage.setImageResource(R.drawable.galge);
            saveHighscore();
            System.out.println("test :(");
        }else{
            finishText.setText("Du har tabt. Ordet var: "+word);
            finishImage.setImageResource(R.drawable.forkert6);
        }




    }

    public void saveHighscore(){
        ArrayList<Integer> highScore = new ArrayList<>();

        //Jeg starer med at loade det der er i prefecne mangeren så jeg indlæser de gamle highscores.
        Gson gsonLoad  = new Gson();
        String jsonLoad = preferences.getString("highScore",null);
        //Konvertere fra Json til ArrayList
        //
        if(jsonLoad!=null){
            highScore = gsonLoad.fromJson(jsonLoad,ArrayList.class);    
        }
        //Tilføjer den nye high score
        highScore.add(score);
        SharedPreferences.Editor prefsEditor = preferences.edit();
        Gson gsonInput = new Gson();
        //Laver ArrayListen om til et JSON object
        String json = gsonInput.toJson(highScore);
        prefsEditor.putString("highScore",json);
        //Tilføjer objektet til Prefence manageren.
        prefsEditor.apply();


        for (int i = 0; i <highScore.size() ; i++) {
            System.out.println("Indput: "+highScore.get(i));
        }
    }
}