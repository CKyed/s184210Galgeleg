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
        System.out.println(hasWon);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);


        if(hasWon){
            finishText.setText("Tillykke. Du har vundet! :D");
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
        score = bundle.getInt("attempts");
        ArrayList<Integer> highScore;

        //Jeg starer med at loade det der er i prefecne mangeren så jeg indlæser de gamle highscores.
        Gson gsonLoad  = new Gson();
        String jsonLoad = preferences.getString("highScore","");
        //Konvertere fra Json til ArrayList
        highScore = gsonLoad.fromJson(jsonLoad,ArrayList.class);
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

        /*
        for (int i = 0; i <5 ; i++) {
            System.out.println("Test2."+i);
            highScore.add(i);
            //Alle de tidligere antal forsøg bliver loadet ind i min ArrayList. ArrayListen har en længde på 5 uansethvad
            highScore.set(i,preferences.getInt("score"+i,0));
        }
        //Min score bliver tilføjet ArrayListen. Længden er nu 6
        highScore.add(score);
        //ArrayListen bliver nu sorteret, laveste værdi er først.
        Collections.sort(highScore);
        System.out.println("test3");
        //De 5 laveste værdier bliver gemt i prefences, med mindre at den laveste værdi er 0. Hvis scoren ikke er blandt top 5 bliver den ikke gemt.
        for (int i = 0; i < highScore.size(); i++) {
            System.out.println("test4."+i);
            if (!(highScore.get(i)==0)){
            preferences.edit().putInt("score"+i,highScore.get(i));
                System.out.println("Tester mit array");
                System.out.println(""+highScore.get(i));
            }
        }*/
    }
}