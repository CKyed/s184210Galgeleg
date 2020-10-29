package com.example.s184210galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.util.ArrayList;

public class HighscoreActivity extends AppCompatActivity {
    private ArrayList<Integer> highScore = new ArrayList<>();
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        for (int i = 0; i < 5; i++) {
            int score = preferences.getInt("score"+i,0);
            if(score!=0){
                highScore.add(score);
            }
        }
        if(highScore.size()!=0){
            //Her skal vi lave vores listview
            for (int i = 0; i < 5; i++) {
                System.out.println("");

            }
        }




    }
}